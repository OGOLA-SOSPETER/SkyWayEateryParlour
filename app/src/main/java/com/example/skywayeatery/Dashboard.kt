package  com.SosDeveloper.animalapp

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.animation.core.SnapSpec
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.skywayeatery.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Dashboard(navController: NavHostController) {
    var scaffoldState = rememberScaffoldState(drawerState = rememberDrawerState(DrawerValue.Open))
    var expanded by remember { mutableStateOf(false) }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(backgroundColor = DefaultTintColor, elevation = 4.dp) {
                        IconButton(onClick = { expanded = true }) {
                            Icon(Icons.Default.List, contentDescription = "Menu")
                        }
                Card(elevation = 6.dp, modifier = Modifier.width(200.dp).height(500.dp)) {
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        // add menu items here
                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                            ClickableText(text = AnnotatedString("Fresh Fruits"), onClick = {})
                        }
                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                            ClickableText(text = AnnotatedString("Blended Fruits"), onClick = {})
                        }
                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                            ClickableText(text = AnnotatedString("Cupcakes"), onClick = {})
                        }
                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                            ClickableText(text = AnnotatedString("Buns"), onClick = {})
                        }
                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                            ClickableText(text = AnnotatedString("Soft Drinks"), onClick = {})
                        }
                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                            ClickableText(text = AnnotatedString("Fries"), onClick = {})
                        }
                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                            ClickableText(text = AnnotatedString("Choma"), onClick = {})
                        }
                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                            ClickableText(text = AnnotatedString("Pizza"), onClick = {})
                        }
                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                            ClickableText(text = AnnotatedString("Snacks"), onClick = {})
                        }

                    }
                }
                }
                Text(text = "\t\tSkyWay Eatery")
Spacer(modifier = Modifier.width(40.dp))
                IconButton(onClick = { navController.navigate("payment") }) {
                    Image(painter = painterResource(id = R.drawable.payment),
                        contentDescription = "Payments")
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
                    OutlinedButton(modifier = Modifier.width(150.dp), onClick = { /*TODO*/ }) {
                        Text(text = idList[index])
                    }

                }

            })

            DisplayImages(navController = rememberNavController())
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



@OptIn(ExperimentalPagerApi::class, ExperimentalAnimationApi::class)
@Composable
fun DisplayImages(navController: NavHostController){
    val images = listOf(
        R.drawable.burgers_remov,
        R.drawable.cupcakes,
        R.drawable.frrut,
        R.drawable.grapes1,
        R.drawable.orange
    )


    val pagerState = rememberPagerState(images.size)

    LaunchedEffect(Unit) {
        while (true) {
            delay(5000) // Delay for 3 seconds
            val nextPage = (pagerState.currentPage + 1) % images.size
            pagerState.scrollToPage(nextPage)
        }
    }

    HorizontalPager(
        count = images.size,
        modifier = Modifier.fillMaxWidth(),
        state = pagerState,
    ) { page ->
        AnimatedVisibility(
            visible = true,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Card(elevation = 4.dp, modifier = Modifier
                .fillMaxWidth(0.9f)
                .animateEnterExit(
                    // Slide in/out the inner box.
                    enter = slideInHorizontally(animationSpec = SnapSpec(2000)),
                    exit = slideOutHorizontally(animationSpec = SnapSpec(2000))
                )
                .background(Color.Red)
                , content = {
                    Image(
                        painter = painterResource(id = images[page]),
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier.size(width = 200.dp, height = 200.dp),
                        colorFilter = ColorFilter.tint(
                            Color.Green, blendMode = BlendMode.DstOver,

                            )
                    )
                }
            )
        }
    }
}