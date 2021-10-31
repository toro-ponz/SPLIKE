package com.toroponz.splike.user.presentation.expression

import com.toroponz.splike.user.domain.entity.UserAuthenticationInformation
import com.toroponz.splike.user.presentation.resource.UserAuthenticationInformationResource

internal fun UserAuthenticationInformation.toResource() = UserAuthenticationInformationResource(
    email = this.email
)
