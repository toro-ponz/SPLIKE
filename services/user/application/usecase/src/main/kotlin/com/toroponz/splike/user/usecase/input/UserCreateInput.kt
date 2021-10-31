package com.toroponz.splike.user.usecase.input

data class UserCreateInput(
    val userKey: String,
    val name: String,
    val email: String,
    val password: String
)
