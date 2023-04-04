package com.abdulaziz.animekmm.android.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulaziz.animekmm.android.ui.theme.AppStyles

@Composable
fun AppEditText(
    defaultLabel: String = "",
    defaultValue: String = "",
    defaultHint: String = "",
    fieldType: Int = 0,
    passwordVisible: Boolean = true,
    height: Dp = 70.dp,
    maxLines: Int = 1,
    action: ImeAction = ImeAction.Next,
    isError:Boolean=false,
    onValueChange: (String) -> Unit = {}
) {
    var editTextValue by remember { mutableStateOf(defaultValue) }
    var editTextHint by remember { mutableStateOf(defaultHint) }
    var showText by remember { mutableStateOf(passwordVisible) }
//    var eyeIcon by remember { mutableStateOf(R.drawable.ic_eye) }
    val annotatedString = buildAnnotatedString {
        append(defaultLabel)
        withStyle(style = SpanStyle(Color.Red)) {
            append("*")
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
    ) {
        Text(text = annotatedString, style = AppStyles.textLabel)
        OutlinedTextField(
            value = editTextValue,
            maxLines = maxLines,
            textStyle = TextStyle(fontSize = 12.sp),
            visualTransformation = if (showText || fieldType == 0) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = if (fieldType == 2) KeyboardType.Email else if (fieldType == 3)KeyboardType.Number else KeyboardType.Text,
                imeAction = action
            ),
            trailingIcon = {
                if (fieldType == 1) {
                    IconButton(
                        onClick = {
//                            eyeIcon = if (showText) R.drawable.ic_eye else R.drawable.ic_eye_closed
                            showText = !showText
                        },
                    ) {
//                        Image(painterResource(id = eyeIcon), contentDescription = "", Modifier.size(18.dp))
                    }
                }
            },
            onValueChange = {
                editTextValue = it
                onValueChange(it)
            },
            label = {
                Text(text = editTextHint)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .onFocusChanged {
                    editTextHint = if (it.hasFocus) {
                        ""
                    } else {
                        if (editTextValue.isEmpty())
                            defaultHint
                        else ""
                    }
                },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = if (isError ) Color.Red else MaterialTheme.colors.background,
                unfocusedIndicatorColor = if (isError) Color.Red else Color.LightGray,
                disabledIndicatorColor = Color.LightGray
            ),
        )
    }
}