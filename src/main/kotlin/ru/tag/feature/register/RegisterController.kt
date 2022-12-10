package ru.tag.feature.register

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import ru.tag.database.tokens.TokenDTO
import ru.tag.database.tokens.Tokens
import ru.tag.database.users.UserDTO
import ru.tag.database.users.Users
import ru.tag.utils.isValidEmail
import java.util.*

class RegisterController() {

    suspend fun registerNewUser(call: ApplicationCall) {

        val registerReceiveRemote = call.receive<RegisterReceiveRemote>()
        if (!registerReceiveRemote.email.isValidEmail()) {
            call.respond(HttpStatusCode.BadRequest, "Email is not valid")
        }

        val userDTO = Users.fetchUser(registerReceiveRemote.login)

        if (userDTO != null) {
            call.respond(HttpStatusCode.Conflict, "User already exists")
        } else {
            val token = UUID.randomUUID().toString()
            Users.insert(
                UserDTO(
                    login = registerReceiveRemote.login,
                    password = registerReceiveRemote.password,
                    username = registerReceiveRemote.username,
                    email = registerReceiveRemote.email
                )
            )
            Tokens.insert(
                TokenDTO(
                    rowId = UUID.randomUUID().toString(),
                    login = registerReceiveRemote.login,
                    token = token
                )
            )
            call.respond(RegisterResponseRemote(token = token, username = registerReceiveRemote.username))
        }
    }
}