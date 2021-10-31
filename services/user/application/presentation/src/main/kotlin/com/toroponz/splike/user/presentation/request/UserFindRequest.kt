package com.toroponz.splike.user.presentation.request

import com.toroponz.splike.user.usecase.input.UserFindInput

data class UserFindRequest(
    val userKey: String
) {
    fun toInput(): UserFindInput = UserFindInput(
        userKey = this.userKey
    )
}
