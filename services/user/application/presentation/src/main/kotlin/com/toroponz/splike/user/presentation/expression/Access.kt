package com.toroponz.splike.user.presentation.expression

import com.toroponz.splike.user.domain.entity.Access
import com.toroponz.splike.user.presentation.resource.AccessResource

internal fun Access.toResource() = AccessResource(
    uuid = this.uuid,
    accessedAt = this.accessedAt.formatIsoOffsetDateTime()
)
