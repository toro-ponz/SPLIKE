package com.toroponz.splike.user.presentation.request

import com.toroponz.splike.user.usecase.input.AccessCreateInput

data class AccessCreateRequest(
    val uuid: String
) {
    fun toInput(): AccessCreateInput = AccessCreateInput(
        uuid = this.uuid
    )
}
