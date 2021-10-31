package com.toroponz.splike.user.usecase.output

import com.toroponz.splike.user.domain.entity.Access

/**
 * アクセス情報の作成の処理結果
 */
sealed class AccessCreateOutput {
    /**
     * 成功
     */
    data class Success(
        val access: Access
    ) : AccessCreateOutput()

    /**
     * ユーザーが存在しない
     */
    object UserNotFound : AccessCreateOutput()
}
