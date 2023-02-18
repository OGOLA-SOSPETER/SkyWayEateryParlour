package com.example.skywayeateryparlour.Foods

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.skywayeatery.R
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.util.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FreshFruits(navController: NavHostController) {
    Column {
        val scope = rememberCoroutineScope()
        var scaffoldState = rememberScaffoldState()
        Scaffold(scaffoldState = scaffoldState,
            modifier = Modifier,
            drawerElevation = 6.dp,
            topBar = {
                TopAppBar (backgroundColor = Color.Transparent){
                    IconButton(onClick = { navController.navigate("Dashboard") }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "back to home")
                    }
                    Spacer(modifier = Modifier.width(50.dp))
                    Text(text = "Fresh Fruits")

                    Spacer(modifier = Modifier.width(50.dp))
                    Icon(Icons.Default.ShoppingCart,"my cart", tint = Color.Magenta)
                }
            },
            drawerContent = {

            },
            content = {
                Column {
                    Text(text = "Get your order sorted in seconds.",Modifier.offset(40.dp))
                    Text(text = "Get a soft drink that soothes you soul.",Modifier.offset(40.dp))
                    FruitsPage(navController = rememberNavController())
                }

            },
            floatingActionButton = {
                FloatingActionButton(
                    content = {Icon(Icons.Default.AddCircle, contentDescription = "floating button")},
                    onClick = {
                        scope.launch {
                            scaffoldState.snackbarHostState
                                .showSnackbar("     Make your order first.")
                        }
                    }
                )
            }, floatingActionButtonPosition = FabPosition.End

        )
    }
}
@Preview
@Composable
fun PreviewFruits(){
    FreshFruits(navController = rememberNavController())
}



data class Fruit(
    val name: String,
    val description: String,
    val price: Double,
    val image: Int
)

val fruitsList = listOf(
    Fruit("Apple", "A sweet and juicy fruit", 100.0, R.drawable.apples),
    Fruit("Banana", "A tasty and nutritious fruit", 50.0, R.drawable.bananas),
    Fruit("Cherry", "A small and flavorful fruit", 250.00, R.drawable.cherry),
    Fruit("Grapes", "A refreshing and versatile fruit", 70.50, R.drawable.grape),
    Fruit("Kiwi", "A fuzzy and tangy fruit", 80.0, R.drawable.kiwi),
    Fruit("Mango", "A tropical and delicious fruit", 45.0, R.drawable.mango),
    Fruit("Orange", "A citrus and juicy fruit", 35.0, R.drawable.orange),
    Fruit("Pineapple", "A prickly and sweet fruit", 200.0, R.drawable.pineapple),
    Fruit("Strawberry", "A small and succulent fruit", 130.0, R.drawable.strawberry),
    Fruit("Watermelon", "A large and refreshing fruit", 250.0, R.drawable.watermelon)
)

@Composable
fun FruitsPage(navController: NavHostController) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(fruitsList) { fruit ->
                FruitsCard(fruit = fruit)
            }
            item {
            }
        }
    }
}

@Composable
fun FruitsCard(fruit: Fruit) {
    Card(
        modifier = Modifier.padding(16.dp)
    ) {
        Row {
            Column {
                val image = painterResource(id = fruit.image)
                Image(
                    painter = image,
                    contentDescription = fruit.name,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(120.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = fruit.name,
                    style = MaterialTheme.typography.h5
                )
                Text(
                    text = fruit.description,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                Text(
                    text = "Kshs. ${fruit.price}",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(vertical = 4.dp)
                )

                AddToCartButton(fruit = fruit)
            }
            }
        }
    }


@Composable
fun AddToCartButton(fruit: Fruit) {
    val cartItems = remember { mutableStateOf(0) }

    Button(
        onClick = { cartItems.value += 1 },
        modifier = Modifier.padding(top = 8.dp).width(140.dp),
        colors = ButtonDefaults.buttonColors(Color.Blue),
        shape = RoundedCornerShape(4.dp)
        ) {
        Text(text = "Add to cart")
    }

    if (cartItems.value > 0) {
        Row(
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(
                text = "Items in cart: ${cartItems.value}",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(end = 8.dp)
            )
            Button(
                onClick = { cartItems.value -= 1 },
                modifier = Modifier.size(24.dp)
            ) {
                Text(text = "-")
            }

        }
        val totalCost = cartItems.value * fruit.price
        Text(
            text = "The total cost  = : $totalCost",
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(end = 8.dp)
        )
    }
}