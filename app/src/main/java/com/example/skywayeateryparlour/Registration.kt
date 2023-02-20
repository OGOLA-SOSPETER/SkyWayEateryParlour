package com.example.skywayeatery

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.skywayeateryparlour.R


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RegistrationScreen(navController: NavHostController) {

    val context = LocalContext.current
    val name = remember {
        mutableStateOf(TextFieldValue())
    }
    val email = remember { mutableStateOf(TextFieldValue()) }
    val countryCode = remember { mutableStateOf(TextFieldValue()) }
    val mobileNo = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }
    val confirmPassword = remember { mutableStateOf(TextFieldValue()) }

    val nameErrorState = remember { mutableStateOf(false) }
    val emailErrorState = remember { mutableStateOf(false) }
    val passwordErrorState = remember { mutableStateOf(false) }
    val confirmPasswordErrorState = remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    var scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState,
        modifier = Modifier,
        drawerElevation = 6.dp,
        backgroundColor = Color.Transparent,
        topBar = {
            TopAppBar {
                IconButton(onClick = {navController.navigate("Dashboard") }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "back to home")
                }
                Spacer(modifier = Modifier.width(50.dp))
                Text(text = "Registration")
            }
        },
        drawerContent = {
            Text(text = "Get your order sorted in seconds.")
            Text(text = "Make your order now.")
        }

    ) {

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
    ) {

        Text(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Red)) {
                append("R")
            }
            withStyle(style = SpanStyle(color = Color.Black)) {
                append("egistration")
            }
        }, fontSize = 30.sp)
        Spacer(Modifier.size(16.dp))
        OutlinedTextField(
            value = name.value,
            onValueChange = {
                if (nameErrorState.value) {
                    nameErrorState.value = false
                }
                name.value = it
            },

            modifier = Modifier.fillMaxWidth(),
            isError = nameErrorState.value,
            label = {
                Text(text = "Name*")
            },
        )
        if (nameErrorState.value) {
            Text(text = "Required", color = Color.Red)
        }
        Spacer(Modifier.size(16.dp))

        OutlinedTextField(
            value = email.value,
            onValueChange = {
                if (emailErrorState.value) {
                    emailErrorState.value = false
                }
                email.value = it
            },

            modifier = Modifier.fillMaxWidth(),
            isError = emailErrorState.value,
            label = {
                Text(text = "Email*")
            },
        )
        if (emailErrorState.value) {
            Text(text = "Required", color = Color.Red)
        }
        Spacer(modifier = Modifier.size(16.dp))
        Row {
            OutlinedTextField(
                value = countryCode.value,
                onValueChange = {

                    countryCode.value = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    autoCorrect = false

                ),
                modifier = Modifier.fillMaxWidth(0.4f),
                label = {
                    Text(text = "Code")
                }, maxLines = 1
            )
            Spacer(modifier = Modifier.size(16.dp))
            OutlinedTextField(
                value = mobileNo.value,
                onValueChange = {

                    mobileNo.value = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    autoCorrect = false
                ),
                label = {
                    Text(text = "Mobile No")
                },
            )
        }

        Spacer(Modifier.size(16.dp))
        val passwordVisibility = remember { mutableStateOf(true) }
        OutlinedTextField(
            value = password.value,
            onValueChange = {
                if (passwordErrorState.value) {
                    passwordErrorState.value = false
                }
                password.value = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Password*")
            },
            isError = passwordErrorState.value,
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility.value = !passwordVisibility.value
                }) {
                     if (passwordVisibility.value)
                            Image(painter = painterResource(id = R.drawable.visibility_off),contentDescription = "visibility off",)
                         else
                            Image(painter = painterResource(id = R.drawable.visibility),contentDescription = "visibility")

                }
            },
            visualTransformation = if (passwordVisibility.value) PasswordVisualTransformation() else VisualTransformation.None
        )
        if (passwordErrorState.value) {
            Text(text = "Required", color = Color.Red)
        }

        Spacer(Modifier.size(16.dp))
        val cPasswordVisibility = remember { mutableStateOf(true) }
        OutlinedTextField(
            value = confirmPassword.value,
            onValueChange = {
                if (confirmPasswordErrorState.value) {
                    confirmPasswordErrorState.value = false
                }
                confirmPassword.value = it
            },
            modifier = Modifier.fillMaxWidth(),
            isError = confirmPasswordErrorState.value,
            label = {
                Text(text = "Confirm Password*")
            },
            trailingIcon = {
                IconButton(onClick = {
                    cPasswordVisibility.value = !cPasswordVisibility.value
                }) {
                    if (passwordVisibility.value)
                        Image(painter = painterResource(id = R.drawable.visibility_off),contentDescription = "visibility off",)
                    else
                        Image(painter = painterResource(id = R.drawable.visibility),contentDescription = "visibility")

                }
            },
            visualTransformation = if (cPasswordVisibility.value) PasswordVisualTransformation() else VisualTransformation.None
        )
        if (confirmPasswordErrorState.value) {
            val msg = if (confirmPassword.value.text.isEmpty()) {
                "Required"
            } else if (confirmPassword.value.text != password.value.text) {
                "Password not matching"
            } else {
                ""
            }
            Text(text = msg, color = Color.Red)
        }
        Spacer(Modifier.size(16.dp))
        Button(
            onClick = {
                when {
                    name.value.text.isEmpty() -> {
                        nameErrorState.value = true
                    }
                    email.value.text.isEmpty() -> {
                        emailErrorState.value = true
                    }
                    password.value.text.isEmpty() -> {
                        passwordErrorState.value = true
                    }
                    confirmPassword.value.text.isEmpty() -> {
                        confirmPasswordErrorState.value = true
                    }
                    confirmPassword.value.text != password.value.text -> {
                        confirmPasswordErrorState.value = true
                    }
                    else -> {
                        Toast.makeText(
                            context,
                            "Registered successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                        navController.navigate("Login") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    }
                }
            },
            content = {
                Text(text = "Register", color = Color.White)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        )
        Spacer(Modifier.size(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            TextButton(onClick = {
                navController.navigate("Login") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }) {
                Text(text = "Login", color = Color.Red)
            }
        }
    }
}


@Preview
@Composable
fun PreviewRegister() {
    RegistrationScreen(navController = rememberNavController())
}

data class User(val username: String, val password: String)

fun saveUserDetails(user: User, context: Context) {
    val sharedPref = context.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE) ?: return
    with(sharedPref.edit()) {
        putString("username", user.username)
        putString("password", user.password)
        apply()
    }
}

fun getUserDetails(context: Context): User? {
    val sharedPref = context.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
    val username = sharedPref.getString("username", null)
    val password = sharedPref.getString("password", null)
    return if (username != null && password != null) {
        User(username, password)
    } else {
        null
    }
}