package com.example.skywayeateryparlour

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.skywayeatery.R

@SuppressLint("ResourceType")
@Composable
fun SettingsPage(navController: NavHostController) {
    val colors = Color(0xFF1976D2)
    val cardModifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .padding(16.dp)
    val dividerModifier = Modifier
        .fillMaxWidth()
        .height(1.dp)
        .padding(end = 10.dp)
    val iconModifier = Modifier.size(36.dp)

    Column(Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("MY Settings") },
            elevation = 4.dp, backgroundColor = Color.Transparent,
            navigationIcon = {
                IconButton(onClick = { navController.navigate("Dashboard") }) {
                    Icon(Icons.Filled.ArrowBack, null,
                        modifier = Modifier.size(20.dp),
                    tint = colors
                        )
                }
            },
        )

        Card(Modifier.padding(10.dp), elevation = 6.dp) {
            Column(Modifier.fillMaxSize()) {
                SettingsCard("General", painterResource(id = R.drawable.settings),

                        Modifier.clickable { }) // General
                Spacer(modifier = Modifier.height(5.dp))
                Divider(dividerModifier, color = Color.LightGray)
                Spacer(modifier = Modifier.height(20.dp))
                SettingsCard("Sounds",painterResource(id = R.drawable.call), Modifier.clickable { }) // Sounds
                Spacer(modifier = Modifier.height(5.dp))
                Divider(dividerModifier, color = Color.LightGray)
                Spacer(modifier = Modifier.height(20.dp))
                SettingsCard("App Language", painterResource(id = R.drawable.language), Modifier.clickable { }) // App Language
                Spacer(modifier = Modifier.height(5.dp))
                Divider(dividerModifier, color = Color.LightGray)
                Spacer(modifier = Modifier.height(20.dp))
                SettingsCard("Backup", painterResource(id = R.drawable.backup), Modifier.clickable { }) // Backup
                Spacer(modifier = Modifier.height(5.dp))
                Divider(dividerModifier, color = Color.LightGray)
                Spacer(modifier = Modifier.height(20.dp))
                SettingsCard("Privacy Center", painterResource(id = R.drawable.lock), Modifier.clickable { }) // Privacy Center
                Spacer(modifier = Modifier.height(5.dp))
                Divider(dividerModifier, color = Color.LightGray)
                Spacer(modifier = Modifier.height(20.dp))
                SettingsCard("About Developer", painterResource(id = R.drawable.people), Modifier.clickable { }) // Privacy Center

            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SettingsCard(title: String, image: Painter, onClick: Modifier) {
    Card(
        onClick = {onClick},
        elevation = 4.dp,
        modifier = Modifier.padding( 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier.height(50.dp).width(200.dp)
        ) {
            Image(image, contentDescription = title, modifier =Modifier.size(36.dp) )
            Spacer(modifier = Modifier.width(16.dp))
            Text(title, style = MaterialTheme.typography.subtitle1)
        }
    }
}
@Preview
@Composable
fun SettingsPreview() {
    SettingsPage(navController = rememberNavController())
}