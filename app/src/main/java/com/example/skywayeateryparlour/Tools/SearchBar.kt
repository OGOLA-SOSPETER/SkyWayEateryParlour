package com.example.skywayeateryparlour.Tools

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun SearchBar(navController: NavHostController) {
    Column {
        TextField(
            value = "",
            onValueChange = {},
            label = {
                Text("Search")
            },

            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(5.dp)
        )
    }
}

@Preview
@Composable
fun PreviewSearch(){
    SearchBar(navController = rememberNavController())
}




