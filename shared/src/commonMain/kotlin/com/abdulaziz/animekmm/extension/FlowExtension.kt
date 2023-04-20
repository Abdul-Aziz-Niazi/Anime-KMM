package com.abdulaziz.animekmm.extension

import com.abdulaziz.animekmm.network.ApiState
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

val mainScope = MainScope()

fun Flow<ApiState>.asCompletion(result: (Any?, String?) -> Unit) {

    mainScope.launch {
        collectLatest {
            when (it) {
                is ApiState.Success<*> -> result(it.result , null)
                is ApiState.Failure -> result(null, it.error)
                is ApiState.Loading -> result(null, "Loading")
            }
        }
    }
}