package com.example.skywayeateryparlour

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun PasswordReset(navController: NavHostController) {
    var userNameValue by remember { mutableStateOf(TextFieldValue()) }
    var passwordVisible = remember{ mutableStateOf(false) }
    var passwordValue by remember { mutableStateOf(TextFieldValue()) }
    var newPasswordValue1 by remember { mutableStateOf(TextFieldValue()) }
    var confirmPasswordValue2 by remember { mutableStateOf(TextFieldValue()) }
    val colors = Color(0xFF1976D2)



    Column(
        modifier = Modifier.padding(top = 150.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Card(elevation = 5.dp,
        modifier = Modifier.fillMaxWidth().padding(10.dp)){
            Column {
            Image(
                painter = painterResource(id = R.drawable.reset),
                alignment = Alignment.Center,
                contentDescription = "reset image.",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(
                text = " Password Reset.",
                fontSize = 15.sp,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Thin

            )
            OutlinedTextField(

                value = userNameValue,
                onValueChange = { userNameValue = it },
                maxLines = 1,
                label = { Text("Enter the email: ") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
            var cPasswordVisibility = remember{ mutableStateOf(true) }
            OutlinedTextField(

                value = passwordValue,
                onValueChange = { passwordValue = it },
                //keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters),
                trailingIcon = {
                    IconButton(onClick = {
                        cPasswordVisibility.value = !cPasswordVisibility.value
                    }) {
                        if (passwordVisible.value)
                            Image(painter = painterResource(id = R.drawable.visibility_off),contentDescription = "visibility off",)
                        else
                            Image(painter = painterResource(id = R.drawable.visibility),contentDescription = "visibility")

                    }

                },
                maxLines = 1,

                label = { Text("Enter the Old password") },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                visualTransformation = PasswordVisualTransformation(),
                //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

            )
            OutlinedTextField(
                value = newPasswordValue1,
                onValueChange = { newPasswordValue1 = it },
                //keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters),
                trailingIcon ={
                    IconButton(onClick = {
                        cPasswordVisibility.value = !cPasswordVisibility.value
                    }) {
                        if (passwordVisible.value)
                            Image(painter = painterResource(id = R.drawable.visibility_off),contentDescription = "visibility off",)
                        else
                            Image(painter = painterResource(id = R.drawable.visibility),contentDescription = "visibility")

                    }

                },
                maxLines = 1,

                label = { Text("Enter the New password") },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                visualTransformation = PasswordVisualTransformation(),
                //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

            )
            OutlinedTextField(
                enabled = false,
                value = confirmPasswordValue2,
                onValueChange = { confirmPasswordValue2 = it },
                //keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters),
                trailingIcon = {
                    IconButton(onClick = {
                        cPasswordVisibility.value = !cPasswordVisibility.value
                    }) {
                        if (passwordVisible.value)
                            Image(painter = painterResource(id = R.drawable.visibility_off),contentDescription = "visibility off",)
                        else
                            Image(painter = painterResource(id = R.drawable.visibility),contentDescription = "visibility")

                    }

                },
                maxLines = 1,
                label = { Text("Confirm  the New password") },

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                visualTransformation = PasswordVisualTransformation(),
                //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

            )
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = colors),
                onClick = { navController.navigate("Dashboard") }) {
                Text(
                    "Login",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 1.dp, bottom = 1.dp),
                    color = colors
                )
            }
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.padding(top = 100.dp)
            ) {

                Row {
                    Text(

                        "By:Ogola Sospeter<<Android Developer>>",
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 0.dp, start = 0.dp)
                    )
                }
            }
        }
        }
    }
}

@Preview
@Composable
fun PreviewPass() {
    PasswordReset(navController = rememberNavController())
}