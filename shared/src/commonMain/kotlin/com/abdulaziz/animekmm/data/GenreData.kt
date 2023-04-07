package com.abdulaziz.animekmm.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenreData(
    @SerialName("_id")
    val id: String?
)