package com.toroponz.splike.user.infrastructure.entrypoint

import com.toroponz.splike.user.infrastructure.dependency.ModuleBuilder
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.*
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Locations
import io.ktor.routing.routing
import org.koin.ktor.ext.Koin

@KtorExperimentalLocationsAPI
fun Application.main() {
    install(CallLogging, callLoggingConfiguration)
    install(ContentNegotiation, contentNegotiationConfiguration)
    install(CORS, corsConfiguration)
    install(StatusPages, statusPagesConfiguration)

    install(DefaultHeaders)
    install(Locations)

    install(Koin) { modules(ModuleBuilder.modules) }

    routing {
        root()
    }
}
