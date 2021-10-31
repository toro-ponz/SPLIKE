package com.toroponz.splike.user.presentation.controller

import com.toroponz.splike.user.presentation.expression.toResource
import com.toroponz.splike.user.presentation.request.AccessCreateRequest
import com.toroponz.splike.user.presentation.request.AccessListRequest
import com.toroponz.splike.user.presentation.resource.AccessResource
import com.toroponz.splike.user.usecase.output.AccessCreateOutput
import com.toroponz.splike.user.usecase.output.AccessListOutput
import com.toroponz.splike.user.usecase.service.AccessCreateService
import com.toroponz.splike.user.usecase.service.AccessListService
import java.lang.Exception

/**
 * アクセス情報の処理を制御する
 */
class AccessController(
    private val accessCreateService: AccessCreateService,
    private val accessListService: AccessListService
) {
    /**
     * アクセス情報の作成処理を制御する
     */
    fun create(request: AccessCreateRequest): AccessResource {
        return when (val output = this.accessCreateService.create(request.toInput())) {
            is AccessCreateOutput.Success -> output.access.toResource()
            is AccessCreateOutput.UserNotFound -> throw Exception("TODO")
        }
    }

    /**
     * アクセス情報一覧の取得処理を制御する
     */
    fun list(request: AccessListRequest): List<AccessResource> {
        return when (val output = this.accessListService.list(request.toInput())) {
            is AccessListOutput.Success -> output.accessList.map { it.toResource() }
            is AccessListOutput.UserNotFound -> throw Exception("TODO")
        }
    }
}
