package com.toroponz.splike.user.usecase.service

import com.toroponz.splike.user.domain.entity.User
import com.toroponz.splike.user.domain.entity.UserAuthenticationInformation
import com.toroponz.splike.user.usecase.input.UserCreateInput
import com.toroponz.splike.user.usecase.output.UserCreateOutput
import com.toroponz.splike.user.usecase.repository.UserRepository
import java.security.SecureRandom
import java.security.spec.KeySpec
import java.time.LocalDateTime
import java.util.*
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

class UserCreateServiceImpl(
    private val userRepository: UserRepository
) : UserCreateService {
    override fun create(input: UserCreateInput): UserCreateOutput {
        val now = LocalDateTime.now()

        val uuid = UUID.randomUUID().toString()
        val hashedPassword = this.createPasswordHash(input.password)

        val userAuthenticationInformation = UserAuthenticationInformation(
            email = input.email,
            password = hashedPassword
        )
        val user = User(
            id = 0,
            userKey = input.userKey,
            name = input.name,
            uuid = uuid,
            createdAt = now,
            authenticationInformation = userAuthenticationInformation
        )

        this.userRepository.save(user)

        return UserCreateOutput.Success(user)
    }

    internal fun createPasswordHash(password: String): String {
        val random = SecureRandom()
        val salt = ByteArray(16)
        random.nextBytes(salt)

        val spec: KeySpec = PBEKeySpec(password.toCharArray(), salt, 65536, 128)
        val factory = SecretKeyFactory.getInstance("HMAC-SHA-256")

        return factory.generateSecret(spec).encoded.toString()
    }
}
