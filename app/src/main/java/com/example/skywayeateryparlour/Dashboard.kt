package com.example.skywayeateryparlour

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
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
import breaklist
import com.example.skywayeateryparlour.Foods.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import dinnerList
import freshList
import kotlinx.coroutines.delay
import lunchList
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
                    DropdownMenuItem(
                        onClick = { navController.navigate("beverages") },
                        content = {
                            Text(text = "Beverages")
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
                Spacer(modifier = Modifier.width(22.dp))
                IconButton(onClick = { navController.navigate("payment") }) {
                    Image(
                        painter = painterResource(id = R.drawable.payment),
                        contentDescription = "Payments"
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

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

                IconButton(onClick = { navController.navigate("Dashboard")}) {
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

    //DisplayImages(navController = rememberNavController())
    Content(navController = rememberNavController())

                //DisplayImages(navController = rememberNavController())
                //ModalBottomSheetExample(navController = rememberNavController())

}
    }
}

@Composable
fun Content(navController: NavHostController) {
    //Image(painter = painterResource(id = R.drawable.milk),
        //contentDescription = "background image")
    Column(Modifier.verticalScroll(state = ScrollState(0),enabled = true, flingBehavior = ScrollableDefaults.flingBehavior())){
        LazyRow(horizontalArrangement = Arrangement.spacedBy(5.dp), content = {
            item {
                OutlinedButton(onClick = { navController.navigate("fresh_fruits") }) {
                    Text("Fruits")
                }
            }

            item {
                OutlinedButton(modifier = Modifier.width(100.dp),onClick = { navController.navigate("beverages")}) {
                    Text("Breakfast")
                }
            }
            item {
                OutlinedButton(modifier = Modifier.width(100.dp),onClick = { navController.navigate("fries")}) {
                    Text("Lunch")
                }
            }
            item {
                OutlinedButton(modifier = Modifier.width(100.dp), onClick = { navController.navigate("choma")}) {
                    Text("Dinner")
                }
            }
        }
        )
        Row{
            Text("Combo of the Day:")
            Divider(modifier = Modifier
                .width(250.dp)
                .offset(3.dp, 10.dp), startIndent = 10.dp, color = Color.DarkGray)
        }

        LazyRow(horizontalArrangement = Arrangement.spacedBy(3.dp),content = {
            items(freshList.size){
                index ->
                    Card(modifier = Modifier
                        .width(200.dp)
                        .height(230.dp)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally){
                            Image(painter = painterResource(id = freshList[index].image),
                                contentDescription = freshList[index].description ,
                            modifier = Modifier.size(200.dp))
                       Text(text = freshList[index].description,
                       modifier = Modifier.offset(13.dp,2.dp))
                        }
                    }

            }
        })
        Spacer(modifier = Modifier.height(5.dp))


        Row{
            Text(text = "Breakfast Dishes",
                style = MaterialTheme.typography.h5, modifier = Modifier.padding(top = 10.dp,bottom = 10.dp))
            Divider(modifier = Modifier
                .width(250.dp)
                .offset(3.dp, 25.dp), startIndent = 10.dp, color = Color.DarkGray)

        }
        LazyRow(horizontalArrangement = Arrangement.spacedBy(3.dp), content = {
            items(breaklist.size){
                    index ->
                Card(modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally){
                        Image(painter = painterResource(id = breaklist[index].image),
                            contentDescription = breaklist[index].description ,
                            modifier = Modifier
                                .size(200.dp)
                                .clip(RoundedCornerShape(6.dp)), contentScale = ContentScale.Crop)
                        Text(text = breaklist[index].description,
                            modifier = Modifier.offset(15.dp,2.dp))
                    }

                }
                Text(text = breaklist[index].description,
                    modifier = Modifier.offset(13.dp,2.dp))
            }
        })
        Spacer(modifier = Modifier.height(5.dp))

        Row{
            Text(text = "Lunch Special ",
                style = MaterialTheme.typography.h5, modifier = Modifier.padding(top = 10.dp,bottom = 10.dp))
            Divider(modifier = Modifier
                .width(250.dp)
                .offset(3.dp, 25.dp), startIndent = 10.dp, color = Color.DarkGray)

        }
        LazyRow(horizontalArrangement = Arrangement.spacedBy(3.dp),content = {
            items(lunchList.size){
                    index ->
                Card(modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally){
                        Image(painter = painterResource(id = lunchList[index].image),
                            contentDescription = lunchList[index].description ,
                            modifier = Modifier.size(200.dp).clip(RoundedCornerShape(4.dp)),
                        contentScale = ContentScale.Crop)
                        Text(text = lunchList[index].description,
                            modifier = Modifier.offset(15.dp,2.dp))
                    }

                }
                Text(text = lunchList[index].description,
                    modifier = Modifier.offset(13.dp,2.dp))
            }
        })

        Row{
            Text(text = "..Dinner Specials..",
                style = MaterialTheme.typography.h5, modifier = Modifier.padding(top = 10.dp,bottom = 10.dp))
            Divider(modifier = Modifier
                .width(250.dp)
                .offset(3.dp, 25.dp), startIndent = 10.dp, color = Color.DarkGray)

        }
        LazyRow(horizontalArrangement = Arrangement.spacedBy(3.dp), content = {
            items(breaklist.size){
                    index ->
                Card(modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally){
                        Image(painter = painterResource(id = breaklist[index].image),
                            contentDescription = breaklist[index].description ,
                            modifier = Modifier
                                .size(200.dp)
                                .clip(RoundedCornerShape(6.dp)), contentScale = ContentScale.Crop)
                        Text(text = breaklist[index].description,
                            modifier = Modifier.offset(15.dp,2.dp))
                    }

                }
                Text(text = dinnerList[index].description,
                    modifier = Modifier.offset(13.dp,2.dp))
            }
        })
        Text(text = "Welcome for Tasty Delicacies..")

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
        Green
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
                modifier = Modifier
                    .size(width = 300.dp, height = 180.dp)
                    .background(randomItem)
            )
        }
    }
}