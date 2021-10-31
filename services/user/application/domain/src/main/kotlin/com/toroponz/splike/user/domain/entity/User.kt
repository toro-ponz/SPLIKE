package com.toroponz.splike.user.domain.entity

import java.time.LocalDateTime

/**
 * ユーザー情報
 */
data class User(
    /**
     * ID
     */
    val id: Long,

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
    val createdAt: LocalDateTime,

    /**
     * ユーザーの認証情報
     */
    val authenticationInformation: UserAuthenticationInformation? = null
)
