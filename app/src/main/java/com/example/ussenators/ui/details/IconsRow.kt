package com.example.ussenators.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp

@Composable
fun IconsRow(imageRes: Int) {
    Image(
        bitmap = ImageBitmap.imageResource(imageRes),
        contentDescription = null,
        modifier = Modifier.clip(CircleShape)
            .size(40.dp)
            .clickable(onClick = {})
    )
}