package com.android.bibledevotion.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.abdulaziz.animekmm.android.ui.theme.Purple500

@Composable
fun AppText(
    modifier: Modifier,
    text: String = "",
    spannedText: String = "",
    color: Color = Purple500,
    style: TextStyle = TextStyle.Default,
    onClick: () -> Unit
) {
    val annotatedString = buildAnnotatedString {
        append(text)
        withStyle(style = SpanStyle(color = color)) {
            append(spannedText)
        }
    }
    Text(
        text = annotatedString,
        modifier = modifier.clickable(enabled = true) {
            onClick()
        }, style = style
    )
}