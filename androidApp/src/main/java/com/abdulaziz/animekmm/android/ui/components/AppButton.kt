package com.android.bibledevotion.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppButton(modifier: Modifier, text:String="", onClick:()->Unit){
    Button(modifier = modifier.clip(RoundedCornerShape(8.dp)).background(MaterialTheme.colors.background), onClick = {
        onClick()
    }) {
        Text(text = text, color = Color.White)
    }
}