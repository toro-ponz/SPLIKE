package com.toroponz.splike.user.presentation.request

import com.toroponz.splike.user.usecase.input.AccessListInput

data class AccessListRequest(
    val userKey: String,
    val limit: Int? = null,
    val offset: Int? = null
) {
    fun toInput(): AccessListInput = AccessListInput(
        userKey = this.userKey,
        limit = this.limit ?: 40,
        offset = this.offset ?: 0,
    )
}
