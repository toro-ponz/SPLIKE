package com.toroponz.splike.user.usecase.service

import com.toroponz.splike.user.usecase.input.AccessListInput
import com.toroponz.splike.user.usecase.output.AccessListOutput
import com.toroponz.splike.user.usecase.repository.AccessRepository
import com.toroponz.splike.user.usecase.repository.UserRepository

/**
 * アクセス情報の一覧を取得する
 */
class AccessListServiceImpl(
    private val accessRepository: AccessRepository,
    private val userRepository: UserRepository
) : AccessListService {
    /**
     * アクセス情報の一覧を取得する
     */
    override fun list(input: AccessListInput): AccessListOutput {
        val user = this.userRepository.findByUserKey(input.userKey)
            ?: return AccessListOutput.UserNotFound

        val accessList = this.accessRepository.findListByUserId(
            userId = user.id,
            limit = input.limit,
            offset = input.offset
        )

        return AccessListOutput.Success(accessList)
    }
}
