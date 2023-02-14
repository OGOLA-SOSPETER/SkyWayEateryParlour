package  com.SosDeveloper.animalapp

import com.example.skywayeatery.Foods.Burger
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.skywayeatery.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Dashboard(navController: NavHostController) {
    var scaffoldState = rememberScaffoldState(drawerState = rememberDrawerState(DrawerValue.Open))

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(backgroundColor = DefaultTintColor, elevation = 4.dp) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.List, contentDescription = "Overflow Menu.")
                }
                Text(text = "\t\tSkyWay Eatery")
Spacer(modifier = Modifier.width(40.dp))
                IconButton(onClick = { navController.navigate("payment") }) {
                    Image(painter = painterResource(id = R.drawable.payment),
                        contentDescription = "Payments")
                }


            }
        },
        content = {
            Column {
                DashPage(navController = rememberNavController())
            }
        },
        floatingActionButton = {

        },
        bottomBar = {
            BottomAppBar(backgroundColor = DefaultTintColor, elevation = 6.dp) {

                IconButton(onClick = { navController.navigate("slider") }) {
                    Icon(Icons.Filled.ShoppingCart, contentDescription = "Bookings.")
                }
                Spacer(modifier = Modifier.width(35.dp))
                IconButton(onClick = {/*TODO*/ }) {
                    Icon(Icons.Filled.Search, contentDescription = "Searches")
                }
                Spacer(modifier = Modifier.width(30.dp))

                IconButton(onClick = { navController.navigate("burger") }) {
                    Icon(Icons.Filled.Home, contentDescription = "Home Menu.")
                }
                Spacer(modifier = Modifier.width(40.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Image(painter = painterResource(id = R.drawable.people), contentDescription = "List Menu.")
                }

            }
        }
    )
}

@Composable
fun DashPage(navController: NavHostController) {
    Column {
        val idList = mutableListOf(
            "Beverages",
            "Fast Foods",
            "Soft Drinks",
            "Fries",
            "Fresh Juices",
            "Take Aways"
        )
        val listModifier = Modifier
            .fillMaxSize()
            .padding(10.dp)

        LazyRow(
            modifier = listModifier,
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            content = {
                items(6) { index: Int ->
                    OutlinedButton(modifier = Modifier.width(200.dp), onClick = { /*TODO*/ }) {
                        Text(text = idList[index])
                    }

                }

            })
        Burger(navController = rememberNavController())
    }
}


@Composable
fun SearchBar() {
    val (showSearchBar, setShowSearchBar) = remember { mutableStateOf(false) }
    val (searchText, setSearchText) = remember { mutableStateOf("") }

    Column {
        if (showSearchBar) {
            TextField(
                value = searchText,
                onValueChange = { setSearchText(it) },
                label = { Text("Search") },
                modifier = Modifier.fillMaxWidth()
            )
        } else {
            Text(
                text = "Search",
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = { setShowSearchBar(true) })
            )
        }
    }
}

@Preview
@Composable
fun PreviewDashboard() {
    Dashboard(navController = rememberNavController())
}
