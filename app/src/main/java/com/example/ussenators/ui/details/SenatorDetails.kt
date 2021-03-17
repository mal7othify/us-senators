package com.example.ussenators.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ussenators.R
import com.example.ussenators.domain.model.Senator

@Composable
fun SenatorDetail(
    navController: NavController,
    senator: Senator
) {
    val headerImage = if (senator.party == "Republican") {
        R.drawable.republican_logo
    } else {
        R.drawable.democrat_logo
    }
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                backgroundColor = Color.Transparent,
                navigationIcon = {
                    Icon(
                        modifier = Modifier.padding(4.dp)
                            .clickable(
                                onClick = { navController.navigateUp() }
                            ),
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.DarkGray
                    )
                },
                title = { }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp)
        ) {
            Box() {
                Card(
                    modifier = Modifier.padding(
                        top = 40.dp
                    ).fillMaxWidth().align(Alignment.Center),
                    shape = MaterialTheme.shapes.medium,
                    elevation = 10.dp,
                    backgroundColor = Color.White,
                ) {
                    Column() {
                        Text(
                            text = "${senator.person!!.firstname} ${senator.person.lastname}",
                            style = MaterialTheme.typography.h4,
                            textAlign = TextAlign.Center,
                            color = Color(0xFF8b8da1),
                            modifier = Modifier.fillMaxWidth().padding(top = 70.dp, bottom = 8.dp)
                        )
                        Text(
                            text = "Link: ${senator.person.link}",
                            style = MaterialTheme.typography.body1,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth().padding(8.dp)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text(
                                    "Bio Guide ID",
                                    style = MaterialTheme.typography.body1,
                                    color = Color(0xFF8b8da1)
                                )
                                Text(
                                    text = "${senator.person.bioguideid}",
                                    style = MaterialTheme.typography.body1,
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text(
                                    "Party",
                                    style = MaterialTheme.typography.body1,
                                    color = Color(0xFF8b8da1),
                                )
                                Text(
                                    text = "${senator.party}",
                                    style = MaterialTheme.typography.body1,
                                    modifier = Modifier.padding(8.dp)
                                )
                            }
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                        ) {
                            Image(
                                bitmap = ImageBitmap.imageResource(R.drawable.email),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)
                            )
                            Image(
                                bitmap = ImageBitmap.imageResource(R.drawable.phone),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)
                            )
                            Image(
                                bitmap = ImageBitmap.imageResource(R.drawable.speak),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp)
                            )
                        }
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter)
                ) {
                    Image(
                        painter = painterResource(id = headerImage),
                        contentDescription = "Picture of $headerImage",
                        modifier = Modifier.size(100.dp).fillMaxWidth().clip(shape = CircleShape),
                        contentScale = ContentScale.Inside,
                        alignment = Alignment.TopCenter
                    )
                }
            }
            Text(
                text = "Address",
                style = MaterialTheme.typography.body2,
                color = Color(0xFF8b8da1),
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "${senator.extra!!.address}",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "Office",
                style = MaterialTheme.typography.body2,
                color = Color(0xFF8b8da1),
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "${senator.extra.office}",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "Name",
                style = MaterialTheme.typography.body2,
                color = Color(0xFF8b8da1),
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "${senator.person!!.name}",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "Birthday",
                style = MaterialTheme.typography.body2,
                color = Color(0xFF8b8da1),
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "${senator.person.birthday}",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "End Date",
                style = MaterialTheme.typography.body2,
                color = Color(0xFF8b8da1),
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "${senator.enddate}",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "Gender",
                style = MaterialTheme.typography.body2,
                color = Color(0xFF8b8da1),
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "${senator.person.gender}",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "Sort Name",
                style = MaterialTheme.typography.body2,
                color = Color(0xFF8b8da1),
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "${senator.person.sortname}",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "Website",
                style = MaterialTheme.typography.body2,
                color = Color(0xFF8b8da1),
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "${senator.website}",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "Phone",
                style = MaterialTheme.typography.body2,
                color = Color(0xFF8b8da1),
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
            Text(
                text = "${senator.phone}",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )
        }
    }
}
