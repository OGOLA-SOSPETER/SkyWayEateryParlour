package com.example.skywayeatery.Foods

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.skywayeatery.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Burger(navController:NavHostController) {
    Column {
        Card(backgroundColor = Color.Transparent, onClick = { /*TODO*/ }, elevation = 4.dp,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            content = {
                Text(text = "Burger", fontSize = 20.sp, fontFamily = FontFamily.SansSerif)
                Divider(thickness = 3.dp, color = Color.Blue, modifier = Modifier.width(150.dp))

                Image(
                    painter = painterResource(id = R.drawable.burgers_remov),
                    contentDescription = "Burgers"
                )
            })
        Spacer(modifier = Modifier.height(20.dp))
        Card(backgroundColor = MaterialTheme.colors.primarySurface,
            onClick = { /*TODO*/ },
            elevation = 4.dp,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            content = {
                Text(text = "Yummy Burger", fontSize = 20.sp, fontFamily = FontFamily.SansSerif)
                Divider(thickness = 1.dp, color = Color.Blue, modifier = Modifier.width(150.dp))

                Image(
                    painter = painterResource(id = R.drawable.burgar_remov),
                    contentDescription = "Burgers"
                )
            })

        OutlinedButton(
            modifier = Modifier
                .width(300.dp)
                .offset(50.dp),
            elevation = ButtonDefaults.elevation(4.dp),
            onClick = { /*TODO*/ }) {
            Text(text = AnnotatedString("Click to make Order:"), fontSize = 16.sp)
        }

    }

}

@Preview
@Composable
fun PrevBurg(){
    Burger(navController = rememberNavController())
}