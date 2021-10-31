package com.toroponz.splike.user.infrastructure.entrypoint.route

import com.toroponz.splike.user.presentation.controller.UserController
import com.toroponz.splike.user.presentation.request.UserCreateRequest
import com.toroponz.splike.user.presentation.request.UserFindRequest
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.*
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import org.koin.ktor.ext.inject

fun Route.user() {
    val controller: UserController by inject()

    route("/users") {
        get {
            val request = UserFindRequest("toro_ponz")
            val response = controller.find(request)
            call.respond(HttpStatusCode.OK, response)
        }
        post {
            val request = UserCreateRequest(
                userKey = "toro_ponz",
                name = "とろゝ",
                email = "user@splike.toroponz.com",
                password = "user-password"
            )
            val response = controller.create(request)
            call.respond(HttpStatusCode.OK, response)
        }
    }
}
