package com.example.skywayeateryparlour

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.skywayeatery.R
import com.example.skywayeateryparlour.Foods.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlin.*


@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Dashboard(navController: NavHostController) {
    var scaffoldState = rememberScaffoldState(drawerState = rememberDrawerState(DrawerValue.Open))
    var expanded by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(backgroundColor = DefaultTintColor, elevation = 4.dp) {
                IconButton(onClick = { expanded = true }) {
                    Icon(Icons.Default.List, contentDescription = "Menu")
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = !expanded },
                    modifier = Modifier.width(230.dp)
                ) {
                    //Card(elevation = 6.dp, modifier = Modifier.width(200.dp).height(500.dp)) {

                    // add menu items here
                    DropdownMenuItem(
                        onClick = { navController.navigate("fresh_fruits") },
                        content = {
                            Text(text = "Fresh Fruits")
                        })
                    DropdownMenuItem(onClick = { navController.navigate("soft_drink") }, content = {
                        Text(text = "Soft Drinks")
                    })
                    DropdownMenuItem(onClick = { navController.navigate("fries") }, content = {
                        Text(text = "Fries")
                    })
                    DropdownMenuItem({ navController.navigate("choma") }, content = {
                        Text(text = "Choma")
                    })
                    DropdownMenuItem(onClick = { /*TODO*/ }, content = {
                        Text(text = "Pizza")
                    })

                    //}
                }

                Text(text = "\t\tSkyWay Eatery")
                Spacer(modifier = Modifier.width(20.dp))
                IconButton(onClick = { navController.navigate("payment") }) {
                    Image(
                        painter = painterResource(id = R.drawable.payment),
                        contentDescription = "Payments"
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                IconButton(onClick = { navController.navigate("settings") }) {
                    Icon(Icons.Filled.Settings, contentDescription = "settings")
                }
            }
        },

        bottomBar = {
            BottomAppBar(backgroundColor = DefaultTintColor, elevation = 6.dp) {

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.ShoppingCart, contentDescription = "Bookings.")
                }
                Spacer(modifier = Modifier.width(35.dp))
                IconButton(onClick = {/*TODO*/ }) {
                    Icon(Icons.Filled.Search, contentDescription = "Searches")
                }
                Spacer(modifier = Modifier.width(30.dp))

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Home, contentDescription = "Home Menu.")
                }
                Spacer(modifier = Modifier.width(40.dp))
                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(id = R.drawable.people),
                        contentDescription = "List Menu."
                    )
                }

            }
        }
    ) {
Column {
    DisplayImages(navController = rememberNavController())
            DashPage(navController = rememberNavController())

                //DisplayImages(navController = rememberNavController())
                //ModalBottomSheetExample(navController = rememberNavController())

}
    }
}



@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DashPage(navController: NavHostController) {
    data class NavItem(val name: String, val route: String)

    val navItems = mutableListOf(
        NavItem("Beverages", "beverages"),
        NavItem("Fast Foods", "fast_food"),
        NavItem("Soft Drinks", "soft_drink"),
        NavItem("Fries", "fries"),
        NavItem("Fresh Juice", "fresh_fruits"),
        NavItem("Choma", "choma")
    )


    val listModifier = Modifier
        .fillMaxSize()
        .padding(10.dp)

    LazyRow(
        modifier = listModifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        content = {
            items(navItems.size) { item ->
                OutlinedButton(
                    modifier = Modifier.width(120.dp),
                    onClick = {navController.navigate(navItems[item].route) }) {
                    Text(text = navItems[item].name, fontSize = 15.sp)
                }
            }
        }
    )
    data class MyCards(val name: String)
    data class MyColors(val color: Color)

    val Cardsdisplay = mutableListOf(
        MyCards("Number"),
    )

    val ColorCodes = mutableListOf<MyColors>(
        MyColors(Red),
        MyColors(White),
        MyColors(Gray),
        MyColors(Black),
        MyColors(Black ),
        MyColors(Red),
        MyColors(Yellow),
        MyColors(Blue),
        MyColors(Green),

        )
    LazyVerticalGrid(columns = GridCells.Adaptive(100.dp), horizontalArrangement = Arrangement.spacedBy(5.dp),verticalArrangement = Arrangement.spacedBy(5.dp), content = {
        items(40){ index ->
            Column {
                Card(modifier = Modifier.size(100.dp), elevation = 6.dp,
                    backgroundColor = Color.Blue,
                    onClick = {}) {
                    Text(text ="Number ${index}" )
                }
            }
        }
    })

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



@OptIn(ExperimentalPagerApi::class, ExperimentalAnimationApi::class, ExperimentalPagerApi::class)
@Composable
fun DisplayImages(navController: NavHostController) {
    val images = listOf(
        R.drawable.apples,
        R.drawable.cupcakes,
        R.drawable.frrut,
        R.drawable.pineapple,
        R.drawable.orange,
        R.drawable.avocado,
        R.drawable.strawberry_berry,
        R.drawable.red_apple
    )
    val colored = listOf(
        Color.LightGray,
        Color.Cyan,
        Color.Cyan,
        Color.Unspecified,
        Color.Green
    )

    val pagerState = rememberPagerState(images.size)

    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            val nextPage = (pagerState.currentPage + 1) % images.size
            pagerState.scrollToPage(nextPage)
        }
    }

    HorizontalPager(
        count = images.size,
        modifier = Modifier.fillMaxWidth(),
        state = pagerState,
    ) { page ->
        val randomItem = remember { colored.random() }
        AnimatedVisibility(
            visible = pagerState.currentPage == page,
            enter = slideInHorizontally(initialOffsetX = { it }),
            exit = slideOutHorizontally(targetOffsetX = { -it })
        ) {
            Image(
                painter = painterResource(id = images[page]),
                contentScale = ContentScale.FillBounds,
                alignment = Alignment.Center,
                contentDescription = null,
                modifier = Modifier.size(width = 400.dp, height = 180.dp)
                    .background(randomItem)
            )
        }
    }
}