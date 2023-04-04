package com.abdulaziz.animekmm.network

sealed class ApiState {

    class Success<T>(val result: T) : ApiState()
    class Failure(val error: String?) : ApiState()
    object Loading : ApiState()

}

