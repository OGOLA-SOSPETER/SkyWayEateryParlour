package com.example.skywayeatery

import com.example.skywayeatery.Foods.Burger
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.SosDeveloper.animalapp.*
import com.example.skywayeatery.Tools.PaymentPage
import com.example.skywayeatery.Tools.Slider
import com.osDeveloper.animalapp.AboutApp

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "Login"
    ) {
        //Login
        //Dashboard
        //Setting
        composable("Login") { LoginUI(navController) }
        composable("Dashboard") { Dashboard(navController) }
        composable("Forgot password") { PasswordReset(navController) }
        composable("settings") { SettingsPage(navController) }
        composable("About") { AboutApp(navController) }
        composable("Registration") { RegistrationScreen(navController) }
        composable("burger"){ Burger(navController ) }
        composable("payment"){PaymentPage(navController)}
        composable("slider"){ Slider(navController )}

    }
}