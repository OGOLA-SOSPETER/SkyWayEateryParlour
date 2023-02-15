package com.example.skywayeatery.Foods

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FreshFruits(navController: NavHostController) {
    Column {
        Card(elevation = 4.dp, modifier = Modifier.width(250.dp),onClick = { /*TODO*/ }) {
            Text(text = "1:    Select the Fruit of your choice.")
        }
        Spacer(modifier = Modifier.height(2.dp))
        Card(elevation = 4.dp, modifier = Modifier.width(250.dp),onClick = { /*TODO*/ }) {
            Text(text = "2:    Select the Quantity needed")
        }
        Spacer(modifier = Modifier.height(2.dp))
        Card(elevation = 4.dp, modifier = Modifier.width(250.dp),onClick = { /*TODO*/ }) {
            Text(text = "3:    Select the Delivery Method of your choice")
        }
        Spacer(modifier = Modifier.height(2.dp))
        Card(elevation = 4.dp, modifier = Modifier.width(250.dp),onClick = { /*TODO*/ }) {
            Text(text = "4:    Confirm the Due Amount")
        }
        Spacer(modifier = Modifier.height(2.dp))
        Card(elevation = 4.dp, modifier = Modifier.width(250.dp),onClick = { /*TODO*/ }) {
            Text(text = "5:    Proceed to Payment")
        }
    }
}

@Preview
@Composable
fun PreviewFruits(){
    FreshFruits(navController = rememberNavController())
}