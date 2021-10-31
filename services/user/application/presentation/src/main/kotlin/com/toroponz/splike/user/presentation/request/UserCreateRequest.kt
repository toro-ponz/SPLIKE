package com.toroponz.splike.user.presentation.request

import com.toroponz.splike.user.usecase.input.UserCreateInput

data class UserCreateRequest(
    val userKey: String,
    val name: String,
    val email: String,
    val password: String
) {
    fun toInput(): UserCreateInput = UserCreateInput(
        userKey = this.userKey,
        name = this.name,
        email = this.email,
        password = this.password
    )
}
