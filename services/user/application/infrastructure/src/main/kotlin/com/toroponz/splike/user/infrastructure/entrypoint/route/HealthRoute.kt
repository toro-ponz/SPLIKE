package com.toroponz.splike.user.infrastructure.entrypoint.route

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.*
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route

fun Route.health() {
    route("/health") {
        get {
            call.respond(HttpStatusCode.OK)
        }
    }
}
