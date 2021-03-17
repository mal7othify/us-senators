package com.example.ussenators.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.ussenators.domain.model.Senator
import com.google.gson.Gson

@Composable
fun AllSenators(
    senators: List<Senator>,
    navController: NavHostController
) {


    fun navigateToUser(senator: Senator) {
        val senatorJson = Gson().toJson(senator)
        navController.navigate("senatorDetail/$senatorJson")
    }

    LazyColumn(
        Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(senators.size) {
            senators.forEach { senator ->
                SenatorRowItem(
                    senator,
                    onItemClicked = { navigateToUser(senator) }
                )
            }
        }
    }
}
