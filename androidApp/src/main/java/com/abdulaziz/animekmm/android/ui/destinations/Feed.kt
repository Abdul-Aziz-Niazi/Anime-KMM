package com.abdulaziz.animekmm.android.ui.destinations

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.abdulaziz.animekmm.android.MainActivity
import com.abdulaziz.animekmm.android.domain.FeedViewModel
import com.abdulaziz.animekmm.android.ui.components.FeedItem
import com.abdulaziz.animekmm.android.ui.theme.AppStyles
import com.abdulaziz.animekmm.data.FeedItemData
import com.abdulaziz.animekmm.network.ApiState
import com.abdulaziz.animekmm.usercase.FeedItemUseCaseImpl
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun Feed(navController: NavHostController, feedViewModel: FeedViewModel, genre: String?) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current as MainActivity
    var listOfAnime by remember { mutableStateOf(listOf<FeedItemData>()) }
    val feedUseCase = FeedItemUseCaseImpl()
    LaunchedEffect(Unit){
        feedUseCase.getFeedItem(genre).collectLatest {
            when (it) {
                is ApiState.Success<*> -> {
                    listOfAnime = it.result as List<FeedItemData>
                    feedViewModel.showLoader.value = false
                }
                is ApiState.Failure -> {
                    feedViewModel.showLoader.value = false
                    Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_SHORT).show()
                }
                is ApiState.Loading -> {
                    feedViewModel.showLoader.value = true
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

        item {
            if (genre != null && genre.isNotEmpty()) {
                Text(text = "Showing results for top 10 $genre anime", style = AppStyles.textBodySemiBold, modifier = Modifier.padding(8.dp))
            }
        }
        items(items = listOfAnime) { current ->
            FeedItem(current)
        }
    }
}
