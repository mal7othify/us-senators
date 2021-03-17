package com.example.ussenators

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.ussenators.domain.mapJson
import com.example.ussenators.domain.model.Object
import com.example.ussenators.domain.model.Senator
import com.example.ussenators.navigation.Screen
import com.example.ussenators.ui.details.SenatorDetail
import com.example.ussenators.ui.home.AllSenators
import com.example.ussenators.ui.theme.USSenatorsTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapJson(this)
        val objects = Gson().fromJson(mapJson(this), Object::class.java)
        val senatorsSorted = objects.senator!!.sortedWith(
            compareBy(String.CASE_INSENSITIVE_ORDER, { it.person!!.lastname })
        )

        setContent {
            USSenatorsTheme {
                window.statusBarColor = MaterialTheme.colors.primaryVariant.toArgb()
                val navController = rememberNavController()
                Surface(color = MaterialTheme.colors.background) {
                    NavHost(navController, startDestination = Screen.AllSenators.route) {
                        composable(Screen.AllSenators.route) {
                            AllSenators(senatorsSorted, navController)
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
            }
        }
    }
}
