package com.toroponz.splike.user.domain.entity

/**
 * ユーザーの認証情報
 */
data class UserAuthenticationInformation(
    /**
     * メールアドレス
     *
     * RFC2822
     */
    val email: String,

    /**
     * パスワード
     *
     * SHA256でハッシュ化
     */
    val password: String
)
