package com.abdulaziz.animekmm.usercase

import com.abdulaziz.animekmm.data.GenreData
import com.abdulaziz.animekmm.network.ApiState
import com.abdulaziz.animekmm.repository.FeedItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface GenreItemUseCase {
    fun getGenreList(): Flow<ApiState>
}

class GenreItemUseCaseImpl : GenreItemUseCase {
    private val repository = FeedItemRepository()
    override fun getGenreList(): Flow<ApiState> = flow {
        emit(ApiState.Loading)
        kotlin.runCatching {
            repository.getGenreList()
        }.onSuccess {
            emit(ApiState.Success<List<GenreData>>(it))
        }.onFailure {
            emit(ApiState.Failure(it.message))
        }
    }
}