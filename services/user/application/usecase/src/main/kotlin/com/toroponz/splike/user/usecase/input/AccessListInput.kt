package com.toroponz.splike.user.usecase.input

data class AccessListInput(
    val userKey: String,
    val limit: Int,
    val offset: Int
)
