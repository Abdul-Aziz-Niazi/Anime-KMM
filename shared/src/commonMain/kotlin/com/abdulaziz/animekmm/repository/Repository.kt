package com.abdulaziz.animekmm.repository

import com.abdulaziz.animekmm.data.DefaultResponse
import com.abdulaziz.animekmm.data.FeedItemData
import com.abdulaziz.animekmm.network.KtorClient
import com.abdulaziz.animekmm.network.NetworkConstants
import io.ktor.client.call.*
import io.ktor.client.request.*

interface Repository {
    @Throws(Exception::class)
    suspend fun getFeedItemData(): DefaultResponse
}

class FeedItemRepository : Repository {
    private val client = KtorClient.httpClient

    override suspend fun getFeedItemData(): DefaultResponse {
        return client.get(NetworkConstants.BASE_URL + "anime") {
            header("X-RapidAPI-Key", NetworkConstants.API_KEY)
            header("X-RapidAPI-Host", NetworkConstants.HOST)
            parameter("page", 1)
            parameter("size", 10)
            parameter("genres", "Supernatural")
            parameter("sortBy","ranking" )
            parameter("sortOrder","asc" )
        }.body()
    }

}