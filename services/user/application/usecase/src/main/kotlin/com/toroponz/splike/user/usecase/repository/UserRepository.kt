package com.toroponz.splike.user.usecase.repository

import com.toroponz.splike.user.domain.entity.User

/**
 * ユーザー情報の永続化を行う
 */
interface UserRepository {
    /**
     * ユーザー情報を取得する
     */
    fun find(
        id: Long,
        withAuthenticationInformation: Boolean = false
    ): User?

    /**
     * ユーザー情報をユーザーキーから取得する
     */
    fun findByUserKey(
        userKey: String,
        withAuthenticationInformation: Boolean = false
    ): User?

    /**
     * ユーザー情報をUUIDから取得する
     */
    fun findByUUID(
        uuid: String,
        withAuthenticationInformation: Boolean = false
    ): User?

    /**
     * ユーザー情報を保存する
     */
    fun save(
        user: User
    )
}
