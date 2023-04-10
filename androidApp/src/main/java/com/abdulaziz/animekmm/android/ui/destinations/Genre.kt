package com.abdulaziz.animekmm.android.ui.destinations

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.abdulaziz.animekmm.android.MainActivity
import com.abdulaziz.animekmm.android.ui.components.GenreItem
import com.abdulaziz.animekmm.data.GenreData
import com.abdulaziz.animekmm.network.ApiState
import com.abdulaziz.animekmm.usercase.GenreItemUseCaseImpl
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
@Composable
fun Genre(navController: NavHostController) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current as MainActivity
    var listOfAnime by remember { mutableStateOf(listOf<GenreData>()) }

    val genreUseCase = GenreItemUseCaseImpl()
    LaunchedEffect(Unit) {
        genreUseCase.getGenreList().collectLatest {
            when (it) {
                is ApiState.Success<*> -> {
                    listOfAnime = it.result as List<GenreData>
                    context.showLoader.value = false
                }
                is ApiState.Failure -> {
                    context.showLoader.value = false
                    Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_SHORT).show()
                }
                is ApiState.Loading -> {
                    context.showLoader.value = true
                }
            }
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 56.dp)
            .background(MaterialTheme.colors.background)
    ) {
        items(items = listOfAnime) { current ->
            GenreItem(current.id.toString()) {
                navController.navigate("feed/$it")
            }
        }
    }
}