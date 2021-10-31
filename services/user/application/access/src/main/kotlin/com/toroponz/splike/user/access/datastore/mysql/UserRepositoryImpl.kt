package com.toroponz.splike.user.access.datastore.mysql

import com.toroponz.splike.user.access.datastore.mysql.table.UserAuthenticationInformationTable
import com.toroponz.splike.user.access.datastore.mysql.table.UserTable
import com.toroponz.splike.user.domain.entity.User
import com.toroponz.splike.user.domain.entity.UserAuthenticationInformation
import com.toroponz.splike.user.usecase.repository.UserRepository
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import java.time.LocalDateTime

class UserRepositoryImpl() : UserRepository {
    /**
     * ユーザー情報を取得する
     */
    override fun find(
        id: Long,
        withAuthenticationInformation: Boolean
    ): User? {
        return UserTable.select { UserTable.id eq id }
            .limit(1)
            .toResult()
            .withAuthenticationInformation(withAuthenticationInformation)
            .toUser()
            .singleOrNull()
    }

    /**
     * ユーザー情報をユーザーキーから取得する
     */
    override fun findByUserKey(
        userKey: String,
        withAuthenticationInformation: Boolean
    ): User? {
        return UserTable.select { UserTable.userKey eq userKey }
            .limit(1)
            .toResult()
            .withAuthenticationInformation(withAuthenticationInformation)
            .toUser()
            .singleOrNull()
    }

    /**
     * ユーザー情報をUUIDから取得する
     */
    override fun findByUUID(
        uuid: String,
        withAuthenticationInformation: Boolean
    ): User? {
        return UserTable.select { UserTable.uuid eq uuid }
            .limit(1)
            .toResult()
            .withAuthenticationInformation(withAuthenticationInformation)
            .toUser()
            .singleOrNull()
    }

    /**
     * ユーザー情報を保存する
     */
    override fun save(
        user: User
    ) {
        val now = LocalDateTime.now()

        UserTable.update({ UserTable.id eq user.id }) {
            it[this.name] = user.name
            it[this.updatedAt] = now
        }
    }

    private fun Query.toResult(): ResultRows {
        return ResultRows(this.map { it })
    }

    private class ResultRows(
        private val userList: List<ResultRow>,
        private val authenticationInformationList: List<ResultRow>? = null
    ) {
        fun withAuthenticationInformation(with: Boolean): ResultRows {
            if (!with) {
                return this
            }

            val userIdList = this.userList.map { it[UserTable.id].value }
            if (userIdList.isEmpty()) {
                return this
            }

            val authenticationInformationList =
                UserAuthenticationInformationTable.select {
                    UserAuthenticationInformationTable.userId inList userIdList
                }
                    .orderBy(UserAuthenticationInformationTable.userId, SortOrder.ASC)
                    .map { it }

            return ResultRows(this.userList, authenticationInformationList)
        }

        fun toUser(): List<User> {
            val authenticationInformationMap = this.authenticationInformationList
                ?.associate {
                    Pair(
                        it[UserAuthenticationInformationTable.userId],
                        UserAuthenticationInformation(
                            email = it[UserAuthenticationInformationTable.email],
                            password = it[UserAuthenticationInformationTable.password],
                        )
                    )
                }

            return this.userList.map { user ->
                val userId = user[UserTable.id].value

                User(
                    id = user[UserTable.id].value,
                    userKey = user[UserTable.userKey],
                    uuid = user[UserTable.uuid],
                    name = user[UserTable.name],
                    createdAt = user[UserTable.createdAt],
                    authenticationInformation = authenticationInformationMap?.get(userId)
                )
            }
        }
    }
}
