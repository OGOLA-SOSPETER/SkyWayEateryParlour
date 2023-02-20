package com.example.skywayeateryparlour.Foods


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.skywayeateryparlour.R


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Choma(navController: NavHostController){

    var scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState,
        modifier = Modifier,
        drawerElevation = 6.dp,
        topBar = {
            TopAppBar {
                IconButton(onClick = { navController.navigate("Dashboard") }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "back to home")
                }
                Spacer(modifier = Modifier.width(50.dp))
                Text(text = "Choma")
            }
        },
        drawerContent = {
            Text(text = "Get your order sorted in seconds.")
            Text(text = "W e have quality choma that you will get to like.\n" +
                    "Kindly make you order and have a taste of the Skyway Fries")
        }

    ) {
        Column{
            Image(painter = painterResource(id = R.drawable.milk),
                contentDescription = "background image", modifier = Modifier.fillMaxSize())

            Column{
                Text("We do very nice and delicious chomas.\n" +
                        "Welcome and have a taste of our delicacy.")
                data class Chomas(val name: String, val description: String, val image: Int)

                val imagelists = listOf(
                    Chomas("Nyama Choma","Choma from very fresh beef. The taste is more than mouth watering.\n" +
                            "Made by the most rated chefs in town.", R.drawable.cocktail)
                )
                LazyVerticalGrid(columns = GridCells.Fixed(2), horizontalArrangement = Arrangement.spacedBy(4.dp), verticalArrangement = Arrangement.spacedBy(4.dp),
                    content ={
                        items(imagelists.size){index ->
                            Card(elevation = 2.dp) {
                                Image(painter = painterResource(id = imagelists[index].image),
                                    contentDescription = imagelists[index].name)
                                Text(text = imagelists[index].description)
                            }
                        }
                    } )
            }
        }

    }

}

@Preview
@Composable
fun  PreviewChoma(){
    Choma(navController = rememberNavController())
}