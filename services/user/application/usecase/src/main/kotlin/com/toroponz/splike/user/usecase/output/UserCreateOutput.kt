package com.toroponz.splike.user.usecase.output

import com.toroponz.splike.user.domain.entity.User

/**
 * ユーザー情報の作成の処理結果
 */
sealed class UserCreateOutput {
    /**
     * 成功
     */
    data class Success(
        val user: User
    ) : UserCreateOutput()
}
