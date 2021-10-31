package com.toroponz.splike.user.domain.entity

import java.time.LocalDateTime

/**
 * アクセス情報
 */
data class Access(
    /**
     * ユーザーのUUID
     */
    val uuid: String,

    /**
     * アクセス時間
     */
    val accessedAt: LocalDateTime
)
