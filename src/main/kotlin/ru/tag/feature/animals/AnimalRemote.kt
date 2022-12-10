package ru.tag.feature.animals

import kotlinx.serialization.Serializable

@Serializable
data class AnimalReceiveRemote(
    val token: String?
)

@Serializable
data class AnimalResponseRemote(
    val url: String
)