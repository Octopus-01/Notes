package com.learn.notesappyt.presentation.common

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomFilterChip(
    lable: String,
    color: Color,
    selected: Boolean,
    alphaValue: Float = 0.2f,
    onClick: () -> Unit
) {

    FilterChip(
        selected = selected,
        onClick = onClick,
        label = {
            Text(
                text = lable,
                color = color.copy(alpha = 0.7f)
            )
        },
        leadingIcon = if (selected){
            {
                Icon(imageVector = Icons.Filled.Done, contentDescription = "Done icon",
                    tint = color,
                    modifier = Modifier.size(FilterChipDefaults.IconSize))
            }
        }else{
                null
        },
        colors = FilterChipDefaults.filterChipColors().copy(
            containerColor = color.copy(alpha = 0.2f),
            labelColor = color,
            leadingIconColor = color,
            selectedContainerColor = color.copy(alpha = 0.2f),

        ),
        border = null
    )
}