package com.toroponz.splike.user.usecase.service

import com.toroponz.splike.user.usecase.input.UserFindInput
import com.toroponz.splike.user.usecase.output.UserFindOutput

interface UserFindService {
    fun find(input: UserFindInput): UserFindOutput
}
