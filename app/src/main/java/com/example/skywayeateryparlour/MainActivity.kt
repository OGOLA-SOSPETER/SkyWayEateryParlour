package com.example.skywayeateryparlour


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
import com.example.skywayeateryparlour.ui.theme.SkywayEateryParlourTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkywayEateryParlourTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //LoginUI(context = applicationContext)
                    val navController = rememberNavController()
                    AppNavigation()
                }

            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SkywayEateryParlourTheme() {
        //LoginUI(context = LocalContext.current
    }
}