package com.example.ussenators

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.toArgb
import com.example.ussenators.domain.mapJson
import com.example.ussenators.domain.model.Object
import com.example.ussenators.navigation.AppNavigator
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
                window.statusBarColor = MaterialTheme.colors.onBackground.toArgb()
                Surface(color = MaterialTheme.colors.background) {
                    AppNavigator(senatorsSorted)
                }
            }
        }
    }
}
