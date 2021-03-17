package com.example.ussenators.ui.details

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TextRow(title: String, desc: String) {
    Divider(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
    Text(
        text = title,
        style = MaterialTheme.typography.body2,
        color = Color(0xFF8b8da1),
        modifier = Modifier.fillMaxWidth()
    )
    Text(
        text = desc,
        style = MaterialTheme.typography.body1,
        modifier = Modifier.fillMaxWidth()
    )
}
