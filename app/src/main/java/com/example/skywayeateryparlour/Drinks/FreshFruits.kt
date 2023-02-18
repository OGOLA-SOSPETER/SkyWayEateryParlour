package com.example.skywayeateryparlour.Drinks

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SoftDrinks(navController: NavHostController){
    val colors = Color(0xFF067702)

    var scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState,
        modifier = Modifier,
        drawerElevation = 6.dp,
        topBar = {
            TopAppBar(backgroundColor = colors) {
                IconButton(onClick = { navController.navigate("Dashboard") }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "back to home")
                }
                Spacer(modifier = Modifier.width(50.dp))
                Text(text = "Soft Drinks")
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Add, contentDescription ="Add item" )
            }
        },
        floatingActionButtonPosition = FabPosition.End

    ){
        DrinksPage(navController = rememberNavController())

    }

}

@Preview
@Composable
fun  PreviewSoftDrink(){
    SoftDrinks(navController = rememberNavController())
}


data class Drink(
    val name: String,
    val description: String,
    val price: Double,
    val image: Int
)

val drinklist = listOf(
    Drink("Mango Juice","mango",345.5,com.example.skywayeatery.R.drawable.mango1),
    Drink("Orange Juice","orange",345.5,com.example.skywayeatery.R.drawable.orange),
    Drink("Passion Juice","passion",345.5,com.example.skywayeatery.R.drawable.passion),
    Drink("Grape Juice","grape",345.5,com.example.skywayeatery.R.drawable.grape),
    Drink("Avocado Juice","avocado",345.5,com.example.skywayeatery.R.drawable.avocado),
    Drink("Pineapple Juice","pineapple",345.5,com.example.skywayeatery.R.drawable.pineapple),
    Drink("Banana Juice","banana",345.5,com.example.skywayeatery.R.drawable.banana),
    Drink("Melon Juice","melon",345.5,com.example.skywayeatery.R.drawable.watermelon),
    Drink("RedBerry Juice","redberry",345.5,com.example.skywayeatery.R.drawable.cocktl),
    Drink("Mixed Fruit Juice","mixed",345.5,com.example.skywayeatery.R.drawable.mixed),
    Drink("RaspBerry MilkShake","milkshake",300.56,com.example.skywayeatery.R.drawable.raspberrymilkshake)
)


@Composable
fun DrinksPage(navController: NavHostController) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(drinklist) { drink ->
                DrinksCard(drink = drink)
            }

        }
    }
}

@Composable
fun DrinksCard(drink: Drink){
    var orderquantity by remember{ mutableStateOf("") }
    var bill by rememberSaveable{ mutableStateOf(0) }
    Card (elevation = 5.dp, modifier = Modifier.padding(5.dp)){
        Row {
            Column(modifier = Modifier.offset(10.dp)) {
                Icon(painter = painterResource(id = drink.image),
                    contentDescription = drink.description, modifier = Modifier.size(100.dp)
                )
                Text(text = drink.name)
                OutlinedButton(onClick = { /*TODO*/ }) {
                    Text(text ="Order Quantity.")
                    OutlinedTextField(modifier = Modifier.width(40.dp).height(20.dp), maxLines = 1,
                        value = orderquantity,
                        onValueChange = {orderquantity = it}
                        //keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number

                    )

                }
            }
            Column {
                Text(text = "This is fresh ${drink.name} \n" +
                        "Enjoy the freshness of the drink. Refreshing, indeed.")
                Text(text = "    \nUnit price: ${drink.price}")
                OutlinedButton(onClick = {
                    val quantity = orderquantity.toInt()
                    val bill =  quantity * drink.price }) {
                    val quantity = orderquantity.toInt()
                    val bill =  quantity * drink.price
                    Text(text = "The Bill is $bill")
                }
            }
        }
    }
}