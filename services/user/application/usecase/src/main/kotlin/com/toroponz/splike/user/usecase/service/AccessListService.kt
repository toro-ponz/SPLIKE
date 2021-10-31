package com.toroponz.splike.user.usecase.service

import com.toroponz.splike.user.usecase.input.AccessListInput
import com.toroponz.splike.user.usecase.output.AccessListOutput

interface AccessListService {
    fun list(input: AccessListInput): AccessListOutput
}
