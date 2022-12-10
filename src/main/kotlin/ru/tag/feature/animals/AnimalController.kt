package ru.tag.feature.animals

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import ru.tag.database.tokens.Tokens

class AnimalController {
    suspend fun performAuthorizedCall(call: ApplicationCall, successCall: suspend () -> Unit) {
        val animalReceiveRemote = call.receive<AnimalReceiveRemote>()
        val token = animalReceiveRemote.token
        if (token == null) {
            call.respond(HttpStatusCode.Unauthorized, "Need to login")
        } else {
            val tokenDto = Tokens.fetchToken(token)

            if (tokenDto == null) {
                call.respond(HttpStatusCode.BadRequest, "User not found")
            } else {
                successCall()
            }
        }

    }
}