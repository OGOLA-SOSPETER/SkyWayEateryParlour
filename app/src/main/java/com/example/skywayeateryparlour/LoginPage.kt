package com.example.skywayeateryparlour

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import com.example.skywayeatery.User
import com.example.skywayeatery.getUserDetails
import com.example.skywayeatery.saveUserDetails


@Composable
fun LoginPage(navController:NavHostController) {
    val usernameState = remember { mutableStateOf(TextFieldValue()) }
    val passwordState = remember { mutableStateOf(TextFieldValue()) }
    val context = LocalContext.current
    Button(onClick = {
        val user = User(usernameState.value.text, passwordState.value.text)
        saveUserDetails(user, context)
        // Navigate to login screen
        navController.navigate("Dashboard")
    }) {
        Text("Register")
    }

// Login screen
    val user = getUserDetails(context)
    if (user != null) {
        val usernameState = remember { mutableStateOf(TextFieldValue(user.username)) }
        val passwordState = remember { mutableStateOf(TextFieldValue(user.password)) }
        // Show login form with pre-filled values
    } else {
        // Show registration screen
        navController.navigate("Registration")
    }

}
    /*
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Email field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Login button
        Button(
            onClick = {
                // Verify email and password
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    if (verifyLogin(email, password)) {
                        // Password is correct, log in user
                        navController.navigate("Dashboard")
                        // Navigate to home page or some other page
                    } else {
                        // Password is incorrect, display error message
                        errorMessage = "Incorrect password!"
                    }
                } else {
                    // Email or password is empty, display error message
                    errorMessage = "Please enter your email and password"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Error message
        if (errorMessage.isNotEmpty()) {
            Text(errorMessage, color = MaterialTheme.colors.error)
        }

        Spacer(modifier = Modifier.height(16.dp))
        navController.navigate("Registration")
        // Registration link
        TextButton(
            onClick = {
                // Navigate to registration page
                navController.navigate("Registration")
            }
        ) {
            Text("Not registered? Create an account")
        }
    }
}

// Function to verify email and password



fun verifyLogin(email: String, password: String): Boolean {
    var connection: Connection? = null
    var statement: Statement? = null
    var resultSet: ResultSet? = null
    var passwordMatches = false

    try {
        // Connect to the database
        Class.forName("com.mysql.cj.jdbc.Driver")
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password")
        statement = connection.createStatement()

        // Check if the email exists in the database
        val query = "SELECT * FROM users WHERE email='$email'"
        resultSet = statement.executeQuery(query)

        if (resultSet.next()) {
            // If the email exists, check if the password matches
            val hashedPassword = resultSet.getString("password")
            if (BCrypt.checkpw(password, hashedPassword)) {
                // If the password matches, set passwordMatches to true
                passwordMatches = true
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        // Close the database connection
        try {
            resultSet?.close()
            statement?.close()
            connection?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // Return true if the password matches, false otherwise
    return passwordMatches
}

*/