package com.toroponz.splike.user.infrastructure.entrypoint

import com.toroponz.splike.user.infrastructure.entrypoint.route.access
import com.toroponz.splike.user.infrastructure.entrypoint.route.health
import com.toroponz.splike.user.infrastructure.entrypoint.route.user
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.routing.Routing

@KtorExperimentalLocationsAPI
fun Routing.root() {
    access()
    health()
    user()
}
