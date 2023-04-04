package com.abdulaziz.animekmm.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class FeedItemData(
    @SerialName("alternativeTitles")
    val alternativeTitles: List<String?>? = null,
    @SerialName("episodes")
    val episodes: Int?= null,
    @SerialName("genres")
    val genres: List<String?>?= null,
    @SerialName("hasEpisode")
    val hasEpisode: Boolean?= null,
    @SerialName("hasRanking")
    val hasRanking: Boolean?= null,
    @SerialName("_id")
    val id: String?= null,
    @SerialName("image")
    val image: String?= null,
    @SerialName("link")
    val link: String?= null,
    @SerialName("ranking")
    val ranking: Int?= null,
    @SerialName("status")
    val status: String?= null,
    @SerialName("synopsis")
    val synopsis: String?= null,
    @SerialName("thumb")
    val thumb: String?= null,
    @SerialName("title")
    val title: String?= null,
    @SerialName("type")
    val type: String?= null
)