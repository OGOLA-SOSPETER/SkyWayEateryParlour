package com.example.skywayeateryparlour



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.skywayeateryparlour.R


@Composable
fun LoginUI(navController: NavHostController) {
    val colors = Color(0xFF047FF8)
    var userNameValue by remember { mutableStateOf(TextFieldValue()) }
    var passwordValue by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier.padding(top = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {


            //DisplayImages(navController = rememberNavController())
/*
            Image(
                painter = painterResource(id = R.drawable.burgers_remov),
                contentDescription = "logo",
                alignment = Alignment.TopCenter,
                //contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = 20.dp)
                    .size(width = 250.dp, height = 150.dp)
                // .border(
                //   BorderStroke(width = (2.dp), rainbowColorsBrush),
                //   CircleShape
                //)
                //.clip(CircleShape)
            )

 */
            Spacer(modifier = Modifier.height(120.dp))
            Text(
                text = "Welcome to the \nUser Login",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Monospace,
                color = colors,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()


            )
            OutlinedTextField(
                value = userNameValue,
                onValueChange = { userNameValue = it },
                maxLines = 1,
                label = { Text("Enter the email: ", color = colors) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            var passwordVisible by rememberSaveable { mutableStateOf(false) }

            OutlinedTextField(
                value = passwordValue,
                onValueChange = { passwordValue = it },
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters),
                trailingIcon = {
                    val description = if (passwordVisible) "show password" else "Hide password"
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        if (passwordVisible)
                            Image(
                                painter = painterResource(id = R.drawable.visibility),
                                contentDescription = description
                            )
                        else
                            Image(
                                painter = painterResource(id = R.drawable.visibility_off),
                                contentDescription = description
                            )
                    }

                },
                maxLines = 1,
                label = { Text("Enter the password", color = colors) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(100.dp),
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                OutlinedButton(
                    onClick = { navController.navigate("Dashboard") ; },
                    elevation = ButtonDefaults.elevation(5.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colors)
                ) {
                    Text(
                        "Login",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 1.dp, bottom = 1.dp),
                        color = Color.White
                    )
                }

                OutlinedButton(elevation = ButtonDefaults.elevation(5.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colors), onClick = {
                        navController.navigate("Registration") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }) {
                    Text(text = "Register ?", color = Color.White)
                }
            }

            Text(
                AnnotatedString(
                    text = "Or login with"
                ),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                color = colors,
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedButton(modifier = Modifier.width(300.dp), onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.googlelogo),
                    contentDescription = "google login",
                    modifier = Modifier.size(30.dp),

                    )
                Spacer(modifier = Modifier.width(30.dp))
                Text("Google Account Login", color = colors)
            }
            Spacer(modifier = Modifier.height(5.dp))

            OutlinedButton(modifier = Modifier.width(300.dp), onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.logo_facebook),
                    contentDescription = "facebook login",
                    modifier = Modifier.size(30.dp),

                    )
                Spacer(modifier = Modifier.width(0.dp))

                Text("  FaceBook Account Login", color = colors)
            }
            Spacer(modifier = Modifier.height(5.dp))

            OutlinedButton(modifier = Modifier.width(300.dp), onClick = { /*TODO*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.phone),
                    contentDescription = "phone login",
                    modifier = Modifier.size(30.dp),
                )
                Spacer(modifier = Modifier.width(10.dp))

                Text("One Time Password Login", color = colors)
            }

            /*
            Text(
                text = "By clicking Login you agree to our Terms And Conditions\n" +
                        "and our Privacy Policy.",
                color = colors,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 30.dp),
                fontFamily = FontFamily.Default


            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Default.CheckCircle,
                    tint = colors,
                    contentDescription = "checkbox",
                )
            }
*/


            ClickableText(
                text = AnnotatedString("Forgot password?"),
                onClick = { navController.navigate("Forgot password") },
                style = TextStyle(
                    fontSize = 14.sp,
                    color = colors,
                    fontFamily = FontFamily.Default,
                    textDecoration = TextDecoration.Underline
                )
            )
        }
    }
    }


@Preview
@Composable
fun ImagePreviewer() {
    LoginUI(navController = rememberNavController())
}






