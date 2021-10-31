package com.toroponz.splike.user.presentation.expression

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

internal fun LocalDateTime.formatIsoOffsetDateTime() = this.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
