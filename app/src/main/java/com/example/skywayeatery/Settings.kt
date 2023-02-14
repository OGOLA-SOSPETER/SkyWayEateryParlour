package com.SosDeveloper.animalapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.skywayeatery.R

@Composable
fun SettingsPage(navController: NavHostController) {
    Column(modifier = Modifier.background(color = Color.LightGray)) {
        TopAppBar(
            title = {
                Text("MY Settings", color = Color.Black)
            },
            elevation = 4.dp,
            backgroundColor = Color.Transparent,
            //backgroundColor = MaterialTheme.colors.background,
            navigationIcon = {
                IconButton(onClick = { navController.navigate("Dashboard") }) {
                    Icon(Icons.Filled.ArrowBack, null, modifier = Modifier.size(20.dp))
                }
            },

            )

        Box(
            Modifier
                .background(color = Color.Gray)
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Column {
                Spacer(modifier = Modifier.height(50.dp))

                Row {
                    Icon(
                        Icons.Filled.Settings,
                        contentDescription = "General Settings",
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    ClickableText(
                        text = AnnotatedString("General"),
                        onClick = {}
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Divider(
                    modifier = Modifier
                        .width(400.dp)
                        .padding(end = 10.dp),
                    color = Color.LightGray
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    Icon(
                        Icons.Filled.Call,
                        contentDescription = "Sounds",
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    ClickableText(
                        text = AnnotatedString("Sounds"),
                        onClick = {}
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))
                Divider(
                    modifier = Modifier
                        .width(400.dp)
                        .padding(end = 10.dp),
                    color = Color.LightGray
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    Image(
                        painter = painterResource(R.drawable.language),
                        contentDescription = "App Language"
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    ClickableText(
                        text = AnnotatedString("App Language"),
                        onClick = {}
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))
                Divider(
                    modifier = Modifier
                        .width(400.dp)
                        .padding(end = 10.dp),
                    color = Color.LightGray
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    Image(
                        painter = painterResource(R.drawable.backup),
                        contentDescription = "Backup"
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    ClickableText(
                        text = AnnotatedString("Backup"),
                        onClick = {}
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))
                Divider(
                    modifier = Modifier
                        .width(400.dp)
                        .padding(end = 10.dp),
                    color = Color.LightGray
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    Image(
                        painter = painterResource(R.drawable.lock),
                        contentDescription = "Privacy"
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    ClickableText(
                        text = AnnotatedString("Privacy Center"),
                        modifier = Modifier.padding(top = 4.dp),
                        onClick = { navController.navigate("Privacy Policy") }
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Divider(
                    modifier = Modifier
                        .width(400.dp)
                        .padding(end = 10.dp),
                    color = Color.LightGray
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }


}

@Preview
@Composable
fun SettingsPreview() {
    SettingsPage(navController = rememberNavController())
}