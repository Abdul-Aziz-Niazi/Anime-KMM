package com.abdulaziz.animekmm.android.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.abdulaziz.animekmm.data.FeedItemData
import com.abdulaziz.animekmm.android.ui.theme.AppStyles


@Composable
fun FeedItem(feedItemData: FeedItemData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            AsyncImage(
                model = feedItemData.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(150.dp)
                    .padding(16.dp)
                    .clip(RoundedCornerShape(8.dp)),
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = feedItemData.title.toString(), style = AppStyles.textTitle)
                Text(text = "Title Here..", style = AppStyles.textBodySemiBold)
                Text(text = "Title Here..", style = AppStyles.textLabel)
                Text(text = "Title Here..", style = AppStyles.textCaption)
            }
        }
    }

}