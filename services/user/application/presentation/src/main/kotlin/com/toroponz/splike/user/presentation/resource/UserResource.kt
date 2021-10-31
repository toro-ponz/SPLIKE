package com.toroponz.splike.user.presentation.resource

data class UserResource(
    /**
     * ユーザーキー
     *
     * 5～15文字の半角英数字
     */
    val userKey: String,

    /**
     * UUID
     *
     * version 4
     */
    val uuid: String,

    /**
     * ユーザー名
     *
     * 1～20文字の文字列
     */
    val name: String,

    /**
     * 登録日時
     */
    val createdAt: String,

    /**
     * ユーザーの認証情報
     */
    val authenticationInformation: UserAuthenticationInformationResource? = null
)
