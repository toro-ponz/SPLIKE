package com.toroponz.splike.user.usecase.output

import com.toroponz.splike.user.domain.entity.User

/**
 * ユーザー情報の取得の処理結果
 */
sealed class UserFindOutput {
    /**
     * 成功
     */
    data class Success(
        val user: User
    ) : UserFindOutput()

    /**
     * ユーザーが存在しない
     */
    object NotFound : UserFindOutput()
}
