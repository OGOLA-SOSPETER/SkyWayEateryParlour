package com.example.skywayeateryparlour.Foods


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Fries(navController: NavHostController){

    var scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState,
        modifier = Modifier,
        drawerElevation = 6.dp,
        backgroundColor = Color.Transparent,
        topBar = {
            TopAppBar {
                IconButton(onClick = { navController.navigate("Dashboard")}) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "back to home")
                }
                Spacer(modifier = Modifier.width(70.dp))
                Text(text = "Fries")
            }
        },
        drawerContent = {
            Text(text = "Get your order sorted in seconds.")
            Text(text = "Need some fries? Huh!. We got you sorted.")
        }

    ) {

    }

}

@Preview
@Composable
fun  PreviewFries(){
    Fries(navController = rememberNavController())
}