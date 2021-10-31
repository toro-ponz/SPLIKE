package com.toroponz.splike.user.access.datastore.dynamodb

import com.toroponz.splike.user.domain.entity.Access
import com.toroponz.splike.user.usecase.repository.AccessRepository

/**
 * アクセス情報の永続化を行う
 */
class AccessRepositoryImpl : AccessRepository {
    /**
     * アクセス情報を保存する
     */
    override fun save(access: Access) {
        TODO("not implemented")
    }

    /**
     * アクセス情報の一覧をユーザーIDから取得する
     */
    override fun findListByUserId(
        userId: Long,
        limit: Int,
        offset: Int
    ): List<Access> {
        TODO("not implemented")
    }
}
