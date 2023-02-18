package com.example.skywayeateryparlour

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.skywayeatery.R

@Composable
fun AboutApp(navController: NavHostController) {
    Column {


        Column(
            //modifier = Modifier.background(color = Color.Blue),
            verticalArrangement = Arrangement.Center
        ) {


            TopAppBar(
                title = { Text("               About Developer", color = Color.Black) },
                modifier = Modifier.background(color = Color.LightGray),
                actions = {
                    IconButton(onClick = { navController.navigate("Menu") }) {
                        Icon(Icons.Filled.ArrowForward, "BackIcon", tint = Color.Black)
                    }
                }
            )

        }


        val myImage = painterResource(id = R.drawable.alx)
        Box {

            Column(modifier = Modifier) {

                Row(modifier = Modifier.padding(top = 3.dp, start = 140.dp)) {
                    Image(
                        painter = myImage,
                        contentDescription = "Developer's image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .height(50.dp)
                            .width(50.dp)
                    )
                }

            }
        }
        Text(
            text = "Developer's Contact Information:",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        Divider(
            modifier = Modifier
                .width(400.dp)
                .padding(end = 10.dp), color = Color.LightGray
        )

        Box(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp, start = 15.dp)) {
            Image(
                painter = painterResource(id = R.drawable.email),
                contentScale = ContentScale.Crop,
                contentDescription = "Email link.",
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)

            )
            Column(modifier = Modifier.padding(start = 50.dp, top = 5.dp)) {
                ClickableText(
                    text = AnnotatedString("My Email"),
                    onClick = {},
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 15.sp,

                        )

                )
            }
        }
        Divider(
            modifier = Modifier
                .width(400.dp)
                .padding(end = 10.dp), color = Color.LightGray
        )
        Box(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp, start = 15.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ffb),
                contentDescription = "Facebook",
                modifier = Modifier.size(25.dp)

            )
            Column(modifier = Modifier.padding(start = 50.dp, top = 3.dp)) {
                ClickableText(
                    text = AnnotatedString("Get Us on FaceBook"),
                    onClick = {},
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 15.sp,

                        )

                )
            }

        }
        Divider(
            modifier = Modifier
                .width(400.dp)
                .padding(end = 10.dp), color = Color.LightGray
        )

        Box(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp, start = 15.dp)) {
            Image(
                painter = painterResource(id = R.drawable.instagram),
                contentDescription = "Instagram",
                modifier = Modifier.size(30.dp)

            )
            Column(modifier = Modifier.padding(start = 50.dp, top = 3.dp)) {
                ClickableText(
                    text = AnnotatedString("Follow us on Instagram"),
                    onClick = {},
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 15.sp,

                        )

                )
            }
        }
        Divider(
            modifier = Modifier
                .width(400.dp)
                .padding(end = 10.dp), color = Color.LightGray
        )

        Box(modifier = Modifier.padding(top = 30.dp, bottom = 30.dp, start = 10.dp)) {
            Image(
                painter = painterResource(id = R.drawable.whatsapp),
                contentScale = ContentScale.Crop,
                contentDescription = "WhatsApp",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)

            )
            Column(modifier = Modifier.padding(start = 50.dp, top = 3.dp)) {
                ClickableText(
                    text = AnnotatedString("Let's Chat on WhatsApp"),
                    onClick = {},
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 15.sp,

                        )

                )
            }
        }

    }
}

@Preview
@Composable
fun Preview() {
    AboutApp(navController = rememberNavController())
}

