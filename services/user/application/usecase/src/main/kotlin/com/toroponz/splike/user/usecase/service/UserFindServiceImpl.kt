package com.toroponz.splike.user.usecase.service

import com.toroponz.splike.user.usecase.input.UserFindInput
import com.toroponz.splike.user.usecase.output.UserFindOutput
import com.toroponz.splike.user.usecase.repository.UserRepository

class UserFindServiceImpl(
    private val userRepository: UserRepository
) : UserFindService {
    override fun find(input: UserFindInput): UserFindOutput {
        val user = this.userRepository.findByUserKey(input.userKey)
            ?: return UserFindOutput.NotFound

        return UserFindOutput.Success(user)
    }
}
