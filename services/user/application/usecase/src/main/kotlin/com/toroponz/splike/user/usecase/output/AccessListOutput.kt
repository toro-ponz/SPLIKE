package com.toroponz.splike.user.usecase.output

import com.toroponz.splike.user.domain.entity.Access

/**
 * アクセス情報一覧の取得処理結果
 */
sealed class AccessListOutput {
    /**
     * 成功
     */
    data class Success(
        val accessList: List<Access>
    ) : AccessListOutput()

    /**
     * ユーザーが存在しない
     */
    object UserNotFound : AccessListOutput()
}
