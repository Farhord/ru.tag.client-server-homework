package ru.tag.feature.animals

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureAnimalsRouting() {

    routing {
        post("/cat") {
            val animalController = AnimalController()
            animalController.performAuthorizedCall(call) {
                call.respond(
                    AnimalResponseRemote(
                        url = "https://oir.mobi/uploads/posts/2021-05/1620834080_24-oir_mobi-p-samii-smeshnoi-kot-zhivotnie-krasivo-foto-25.jpg"
                    )
                )
            }
        }
        post("/dog") {
            val animalController = AnimalController()
            animalController.performAuthorizedCall(call) {
                call.respond(
                    AnimalResponseRemote(
                        url = "https://www.meme-arsenal.com/memes/2b095142f116f18d09059d873c8dee17.jpg"
                    )
                )
            }
        }
        post("/penguin") {
            val animalController = AnimalController()
            animalController.performAuthorizedCall(call) {
                call.respond(
                    AnimalResponseRemote(
                        url = "https://krot.info/uploads/posts/2022-03/1646792049_9-krot-info-p-zabavnie-pingvini-smeshnie-foto-10.jpg"
                    )
                )
            }
        }
        post("/parrot") {
            val animalController = AnimalController()
            animalController.performAuthorizedCall(call) {
                call.respond(
                    AnimalResponseRemote(
                        url = "https://www.meme-arsenal.com/memes/4bfdab410186548a956dd040fcc56248.jpg"
                    )
                )
            }
        }
        post("/developer") {
            val animalController = AnimalController()
            animalController.performAuthorizedCall(call) {
                call.respond(
                    AnimalResponseRemote(
                        url = "https://thypix.com/wp-content/uploads/lustige-tiere-16.jpg"
                    )
                )
            }
        }
    }
}