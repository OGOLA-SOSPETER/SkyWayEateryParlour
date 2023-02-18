package com.example.skywayeateryparlour.Foods


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Choma(navController: NavHostController){

    var scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState,
        modifier = Modifier,
        drawerElevation = 6.dp,
        topBar = {
            TopAppBar {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "back to home")
                }
                Spacer(modifier = Modifier.width(50.dp))
                Text(text = "Choma")
            }
        },
        drawerContent = {
            Text(text = "Get your order sorted in seconds.")
            Text(text = "W e have quality choma that you will get to like.\n" +
                    "Kindly make you order and have a taste of the Skyway Fries")
        }

    ) {

    }

}

@Preview
@Composable
fun  PreviewChoma(){
    Choma(navController = rememberNavController())
}