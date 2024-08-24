package com.learn.notesappyt.presentation.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.learn.notesappyt.R


@Composable
fun AppOutlinedTextField(

    modifier: Modifier = Modifier,
    value : String,
    onValueChange: (String) -> Unit,
    maxLines : Int = 1,
    height : Dp = 60.dp,
    lable : String

    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(height),
            value = value,
            label = { Text(text = lable)},
            onValueChange = {onValueChange(it)},
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(id = R.color.blue),
                unfocusedBorderColor = colorResource(id = R.color.blue),
                focusedTextColor = colorResource(id = R.color.white),
                unfocusedTextColor = colorResource(id = R.color.white),
                focusedContainerColor = colorResource(id = R.color.blue),
                unfocusedContainerColor = colorResource(id = R.color.blue),
            ),
            maxLines = maxLines,
            shape = RoundedCornerShape(10.dp)
        )

}