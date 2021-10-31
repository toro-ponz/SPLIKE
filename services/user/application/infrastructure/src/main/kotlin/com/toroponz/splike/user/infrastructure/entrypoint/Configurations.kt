package com.toroponz.splike.user.infrastructure.entrypoint

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.SerializationFeature
import com.toroponz.splike.user.presentation.resource.ErrorResource
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.features.CORS
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.jackson.jackson
import io.ktor.response.respond
import org.slf4j.event.Level

val Application.callLoggingConfiguration: CallLogging.Configuration.() -> Unit
    get() = {
        level = Level.TRACE
    }

val Application.corsConfiguration: CORS.Configuration.() -> Unit
    get() = {
        method(HttpMethod.Options)
        method(HttpMethod.Post)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        anyHost()
        allowCredentials = true
    }

val Application.contentNegotiationConfiguration: ContentNegotiation.Configuration.() -> Unit
    get() = {
        jackson {
            configure(SerializationFeature.INDENT_OUTPUT, true)
            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            propertyNamingStrategy = PropertyNamingStrategies.SNAKE_CASE
        }
    }

val Application.statusPagesConfiguration: StatusPages.Configuration.() -> Unit
    get() = {
        exception<Throwable> { it ->
            it.printStackTrace()
            call.respond(
                HttpStatusCode.InternalServerError,
                ErrorResource(
                    message = "Internal Server Error"
                )
            )
        }
    }
