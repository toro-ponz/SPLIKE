package com.toroponz.splike.user.presentation.resource

/**
 * アクセスリソース
 */
data class AccessResource(
    /**
     * ユーザーのUUID
     */
    private val uuid: String,

    /**
     * アクセス時間
     */
    private val accessedAt: String
)
