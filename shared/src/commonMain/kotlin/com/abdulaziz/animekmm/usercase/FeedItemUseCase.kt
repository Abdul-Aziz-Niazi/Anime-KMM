package com.abdulaziz.animekmm.usercase

import com.abdulaziz.animekmm.network.ApiState
import com.abdulaziz.animekmm.repository.FeedItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface FeedItemUseCase {
    fun getFeedItem(): Flow<ApiState>
}

class FeedItemUseCaseImpl : FeedItemUseCase {
    private val repository = FeedItemRepository()
    override fun getFeedItem(): Flow<ApiState> = flow {
        emit(ApiState.Loading)
        kotlin.runCatching {
            repository.getFeedItemData()
        }.onSuccess {
            emit(ApiState.Success(it.data))
        }.onFailure {
            it.printStackTrace()
            emit(ApiState.Failure(it.message))
        }
    }

}