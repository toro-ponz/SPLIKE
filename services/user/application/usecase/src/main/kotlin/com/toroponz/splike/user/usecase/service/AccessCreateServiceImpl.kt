package com.toroponz.splike.user.usecase.service

import com.toroponz.splike.user.domain.entity.Access
import com.toroponz.splike.user.usecase.input.AccessCreateInput
import com.toroponz.splike.user.usecase.output.AccessCreateOutput
import com.toroponz.splike.user.usecase.repository.AccessRepository
import com.toroponz.splike.user.usecase.repository.UserRepository
import java.time.LocalDateTime

/**
 * アクセス情報を作成する
 */
class AccessCreateServiceImpl(
    private val accessRepository: AccessRepository,
    private val userRepository: UserRepository
) : AccessCreateService {
    /**
     * アクセス情報を作成する
     */
    override fun create(input: AccessCreateInput): AccessCreateOutput {
        val (uuid) = input

        this.userRepository.findByUUID(uuid)
            ?: return AccessCreateOutput.UserNotFound

        val now = LocalDateTime.now()
        val access = Access(
            uuid = uuid,
            accessedAt = now
        )
        this.accessRepository.save(access)

        return AccessCreateOutput.Success(access)
    }
}
