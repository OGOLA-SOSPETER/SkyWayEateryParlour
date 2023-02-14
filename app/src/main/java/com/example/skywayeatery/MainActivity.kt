package com.example.skywayeatery


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.skywayeatery.ui.theme.SkyWayEateryTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkyWayEateryTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //LoginUI(context = applicationContext)
                    val navController = rememberNavController()
                    AppNavigation(navController = navController)
                }

            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SkyWayEateryTheme() {
        //LoginUI(context = LocalContext.current
    }
}