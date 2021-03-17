package com.example.ussenators.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ussenators.R
import com.example.ussenators.domain.model.Senator

@Composable
fun SenatorRowItem(
    senator: Senator,
    onItemClicked: (senator: Senator) -> Unit,
) {
    val headerImage = if (senator.party == "Republican") {
        R.drawable.republican_logo
    } else {
        R.drawable.democrat_logo
    }
    Card(
        modifier = Modifier.padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = { onItemClicked(senator) }),
        shape = MaterialTheme.shapes.medium,
        elevation = 10.dp,
        backgroundColor = Color.White
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = headerImage),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit,
            )
            Column(Modifier.padding(PaddingValues(end = 5.dp))) {
                Text(
                    text = "${senator.person!!.firstname} ${senator.person.lastname}",
                    style = MaterialTheme.typography.body1,
                    color = Color(0xFF8b8da1),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = senator.party,
                    modifier = Modifier.padding(bottom = 4.dp),
                    color = Color(0xFF8b8da1),
                )
                Text(
                    text = senator.description,
                    style = MaterialTheme.typography.caption,
                    color = Color.DarkGray
                )
            }
        }
    }
}
