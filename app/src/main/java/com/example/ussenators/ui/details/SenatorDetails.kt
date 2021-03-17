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
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp)
    ) {
        Icon(
            modifier = Modifier.padding(4.dp)
                .clip(CircleShape)
                .size(20.dp)
                .clickable(
                    onClick = { navController.navigateUp() }
                ),
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = Color.DarkGray
        )
        Box() {
            Card(
                modifier = Modifier.padding(
                    top = 40.dp, bottom = 16.dp
                ).fillMaxWidth().align(Alignment.Center),
                shape = MaterialTheme.shapes.medium,
                elevation = 10.dp,
                backgroundColor = Color.White,
            ) {
                Column() {
                    Text(
                        text = "${senator.person!!.firstname} ${senator.person.lastname}",
                        style = MaterialTheme.typography.h5,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.fillMaxWidth().padding(top = 70.dp, bottom = 8.dp)
                    )
                    Text(
                        text = senator.person.link,
                        style = MaterialTheme.typography.body1,
                        color = Color(0xFF8b8da1),
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
                                text = senator.person.bioguideid,
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
                                text = senator.party,
                                style = MaterialTheme.typography.body1,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                    ) {
                        IconsRow(R.drawable.email)
                        IconsRow(R.drawable.phone)
                        IconsRow(R.drawable.speak)
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
                    modifier = Modifier.size(100.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.TopCenter
                )
            }
        }
        TextRow("Address", senator.extra!!.address)
        TextRow("Office", senator.extra.office)
        TextRow("Name", senator.person!!.name)
        TextRow("Birthday", senator.person.birthday)
        TextRow("End Date", senator.enddate)
        TextRow("Gender", senator.person.gender)
        TextRow("Sort Name", senator.person.sortname)
        TextRow("Website", senator.website)
        TextRow("Phone", senator.phone)
    }
}

