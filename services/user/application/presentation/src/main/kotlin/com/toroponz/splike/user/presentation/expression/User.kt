package com.toroponz.splike.user.presentation.expression

import com.toroponz.splike.user.domain.entity.User
import com.toroponz.splike.user.presentation.resource.UserResource

internal fun User.toResource() = UserResource(
    userKey = this.userKey,
    name = this.name,
    uuid = this.uuid,
    createdAt = this.createdAt.formatIsoOffsetDateTime(),
    authenticationInformation = this.authenticationInformation?.toResource()
)
