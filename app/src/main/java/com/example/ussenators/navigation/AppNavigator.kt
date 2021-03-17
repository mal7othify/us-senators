package com.example.ussenators.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.ussenators.domain.model.Senator
import com.example.ussenators.ui.details.SenatorDetail
import com.example.ussenators.ui.home.AllSenators
import com.google.gson.Gson

@Composable
fun AppNavigator(senator: List<Senator>) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.AllSenators.route) {
        composable(Screen.AllSenators.route) {
            AllSenators(senator, navController)
        }
        composable(
            "${Screen.SenatorDetail.route}/{senator}",
            arguments = listOf(
                navArgument("senator") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            backStackEntry.arguments!!.getString("senator")!!.let { json ->
                val senator = Gson().fromJson(json, Senator::class.java)
                SenatorDetail(navController, senator)
            }
        }
    }
}