package com.toroponz.splike.user.presentation.controller

import com.toroponz.splike.user.presentation.expression.toResource
import com.toroponz.splike.user.presentation.request.UserCreateRequest
import com.toroponz.splike.user.presentation.request.UserFindRequest
import com.toroponz.splike.user.presentation.resource.UserResource
import com.toroponz.splike.user.usecase.output.UserCreateOutput
import com.toroponz.splike.user.usecase.output.UserFindOutput
import com.toroponz.splike.user.usecase.service.UserCreateService
import com.toroponz.splike.user.usecase.service.UserFindService

class UserController(
    private val userCreateService: UserCreateService,
    private val userFindService: UserFindService
) {
    /**
     * ユーザー情報の作成処理を制御する
     */
    fun create(request: UserCreateRequest): UserResource {
        return when (val output = this.userCreateService.create(request.toInput())) {
            is UserCreateOutput.Success -> output.user.toResource()
        }
    }

    /**
     * ユーザー情報の取得処理を制御する
     */
    fun find(request: UserFindRequest): UserResource {
        return when (val output = this.userFindService.find(request.toInput())) {
            is UserFindOutput.Success -> output.user.toResource()
            is UserFindOutput.NotFound -> throw Exception("TODO")
        }
    }
}
