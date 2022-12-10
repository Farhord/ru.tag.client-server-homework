package ru.tag

import io.ktor.server.application.*
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import org.jetbrains.exposed.sql.Database
import ru.tag.feature.animals.configureAnimalsRouting
import ru.tag.feature.login.configureLoginRouting
import ru.tag.feature.register.configureRegisterRouting
import ru.tag.plugins.configureSerialization

fun main() {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/client-server-homework",
        driver = "org.postgresql.Driver",
        user = "",
        password = ""
    )

    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureRegisterRouting()
    configureLoginRouting()
    configureAnimalsRouting()
    configureSerialization()
}
