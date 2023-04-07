package com.abdulaziz.animekmm.data
@kotlinx.serialization.Serializable
data class DefaultResponse(val data:ArrayList<FeedItemData>)
@kotlinx.serialization.Serializable
data class DefaultGenreResponse(val data:ArrayList<GenreData>)