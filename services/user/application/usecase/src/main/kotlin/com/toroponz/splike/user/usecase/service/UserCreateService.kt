package com.toroponz.splike.user.usecase.service

import com.toroponz.splike.user.usecase.input.UserCreateInput
import com.toroponz.splike.user.usecase.output.UserCreateOutput

interface UserCreateService {
    fun create(input: UserCreateInput): UserCreateOutput
}
