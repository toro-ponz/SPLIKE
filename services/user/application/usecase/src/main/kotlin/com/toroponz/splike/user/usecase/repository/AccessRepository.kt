package com.toroponz.splike.user.usecase.repository

import com.toroponz.splike.user.domain.entity.Access

/**
 * アクセス情報の永続化を行う
 */
interface AccessRepository {
    /**
     * アクセス情報を保存する
     */
    fun save(access: Access)

    /**
     * アクセス情報の一覧をユーザーIDから取得する
     */
    fun findListByUserId(
        userId: Long,
        limit: Int,
        offset: Int
    ): List<Access>
}
