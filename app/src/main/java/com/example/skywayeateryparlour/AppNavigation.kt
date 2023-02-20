package com.example.skywayeateryparlour

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.skywayeatery.RegistrationScreen
import com.example.skywayeatery.Tools.Slider
import com.example.skywayeateryparlour.Drinks.SoftDrinks
import com.example.skywayeateryparlour.Foods.*
import com.example.skywayeateryparlour.Tools.PaymentPage

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Login"
    ) {
        //Login
        //Dashboard
        //Setting
        composable("route_login"){ LoginPage(navController ) }
        composable("Login") { LoginUI(navController) }
        composable("Dashboard") { Dashboard(navController) }
        composable("Forgot password") { PasswordReset(navController) }
        composable("settings") { SettingsPage(navController) }
        composable("About") { AboutApp(navController) }
        composable("Registration") { RegistrationScreen(navController) }
        composable("payment"){PaymentPage(navController)}
        composable("slider"){ Slider(navController )}
        composable("fresh_fruits"){ FreshFruits(navController)}
        composable("choma"){ Choma(navController )}
        composable("fries"){ Fries(navController )}
        composable("beverages"){ Beverages(navController ) }
        composable("soft_drink"){ SoftDrinks(navController )}
        composable("fast_food"){ FastFoods(navController )}

    }
}