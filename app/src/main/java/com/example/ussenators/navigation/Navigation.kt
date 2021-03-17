package com.example.ussenators.navigation

sealed class Screen(val route: String) {
    object AllSenators : Screen("allSenators")
    object SenatorDetail : Screen("senatorDetail")
}
