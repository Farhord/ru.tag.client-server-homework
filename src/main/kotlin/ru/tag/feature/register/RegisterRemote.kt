package ru.tag.feature.register

import kotlinx.serialization.Serializable

@Serializable
data class RegisterReceiveRemote(
    val login: String,
    val password: String,
    val email: String,
    val username: String
)

@Serializable
data class RegisterResponseRemote(
    val token: String,
    val username: String
)
