package com.abdulaziz.animekmm.android.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.abdulaziz.animekmm.android.R
import com.abdulaziz.animekmm.android.ui.theme.Purple500
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay


@Composable
fun AppLoader(showLoader: Boolean) {
    if (showLoader) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loader))
        val progress by animateLottieCompositionAsState(composition)
        Box(modifier = Modifier.fillMaxSize().background(Purple500)) {
            LottieAnimation(
                modifier = Modifier.align(Alignment.Center).width(150.dp).height(150.dp).clip(CircleShape).background(Color.White),
                composition = composition,
                isPlaying = showLoader,
                restartOnPlay = true,
                iterations = 100,
            )
        }
    }
}