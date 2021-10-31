package com.toroponz.splike.user.infrastructure.entrypoint.route

import com.toroponz.splike.user.presentation.controller.AccessController
import com.toroponz.splike.user.presentation.request.AccessCreateRequest
import com.toroponz.splike.user.presentation.request.AccessListRequest
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import org.koin.ktor.ext.inject

fun Route.access() {
    val controller: AccessController by inject()

    route("/accesses") {
        get {
            val request = AccessListRequest("toro_ponz")
            val response = controller.list(request)
            call.respond(HttpStatusCode.OK, response)
        }
        post {
            val request = AccessCreateRequest("6ca3704c-0c17-48cc-8a53-9a6d313d42b8")
            val response = controller.create(request)
            call.respond(HttpStatusCode.OK, response)
        }
    }
}
