package com.example.skywayeatery.Tools

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun PaymentPage(navController: NavHostController) {
    var paymentMethod by remember { mutableStateOf("") }
    var cardNumber by remember { mutableStateOf("") }
    var cardHolderName by remember { mutableStateOf("") }
    var cardExpirationDate by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(20.dp)) {
        PaymentMethodSelection(paymentMethod) { ->
            paymentMethod
        }
        CardView(paymentMethod, cardNumber, cardHolderName, cardExpirationDate, cvv,
            { number -> cardNumber = number },
            { name -> cardHolderName = name },
            { date -> cardExpirationDate = date }
        ) { code -> cvv = code.toString() }
        PaymentButton()
    }
}

@Composable
fun PaymentMethodSelection(paymentMethod: String, any: Any) {

}

@Composable
fun CardView(
    cardNumber: String,
    cardHolderName: String,
    cardExpirationDate: String,
    cvv: String,
    onCardNumberChange: String,
    onCardHolderNameChange: (String) -> Unit,
    onCardExpirationDateChange: (String) -> Unit,
    onCvvChange: (String) -> Unit,
    param: (Any) -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Payment Information", style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            /*
            TextField(
                value = cardNumber,
                onValueChange = onCardNumberChange,
                label = { Text("Card Number") }
            )
            */
            Spacer(modifier = Modifier.height(9.dp))
            TextField(
                value = cardHolderName,
                onValueChange = onCardHolderNameChange,
                label = { Text("Cardholder name") }
            )
            Spacer(modifier = Modifier.height(9.dp))


                    TextField(
                        value = cardExpirationDate,
                        onValueChange = onCardExpirationDateChange,
                        label = { Text("Expiration date (MM/YY)") }
                    )

            Spacer(modifier = Modifier.height(9.dp))

                    TextField(
                        value = cvv,
                        onValueChange = onCvvChange,
                        label = { Text("CVV") }
                    )


        }
    }
}

@Composable
fun PaymentButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        enabled = true
    ) {
        Text(text = "PAY NOW")
    }
}

@Preview
@Composable
fun PreviewPayment(){
    PaymentPage(navController = rememberNavController())
}