package com.toroponz.splike.user.usecase.service

import com.toroponz.splike.user.usecase.input.AccessCreateInput
import com.toroponz.splike.user.usecase.output.AccessCreateOutput

interface AccessCreateService {
    fun create(input: AccessCreateInput): AccessCreateOutput
}
