package com.example.skywayeateryparlour.Foods


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.skywayeateryparlour.R
import java.util.*

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Beverages(navController: NavHostController){

    var scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState,
        modifier = Modifier,
        drawerElevation = 6.dp,
        topBar = {
            TopAppBar (backgroundColor = Color.Transparent, elevation = 3.dp){
                IconButton(onClick = { navController.navigate("Dashboard")}) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "back to home")
                }
                Spacer(modifier = Modifier.width(50.dp))
                Text(text = "Beverages")
            }
        },
        drawerContent = {
            Text(text = "Get your order sorted in seconds.")
            Text(text = "Have a coffee☕")
        },
        bottomBar = {
            BottomAppBar(backgroundColor = Color.Transparent) {
                IconButton(onClick = { navController.navigate("Dashboard") }, modifier = Modifier.offset(150.dp,3.dp)) {
                    Icon(
                        Icons.Filled.Home, contentDescription = "Back To Home", tint = Color.Gray
                    )
                }
            }
        }

    ) {

        data class Breakfast (val name: String, val price:Int, val image:Int, val description:String)

        val breakfastlist = listOf(
            Breakfast("Coffee", 50, R.drawable.coffee,"" +
                    "Our coffee is made with the highest quality beans, " +
                    "carefully selected from around the world and expertly roasted to perfection. " +
                    "\nFrom light and bright to dark and bold, our coffee options are sure" +
                    "to satisfy any coffee lover's taste. \nWhether you prefer a classic and smooth Colombian, a rich and indulgent Mocha, or a bright and fruity Ethiopian, our coffee is crafted with care " +
                    "and precision to deliver a delicious and satisfying experience with every sip." +
                    ""),
            Breakfast("Tea", 50, R.drawable.tea,"Our tea selection features a wide" +
                    " variety of high-quality teas, sourced from around the world " +
                    "and expertly crafted to deliver a delicious and satisfying experience. " +
                    "\nFrom the classic and robust flavor of our black tea to the delicate" +
                    "and refreshing taste of our green tea, we offer a range of " +
                    "options to suit every taste and preference. Our herbal teas are crafted" +
                    " with a variety of fruits, flowers, and herbs, creating a fragrant and " +
                    "flavorful experience that can be enjoyed any time of day. Whether you prefer " +
                    "the rich and spicy taste of our chai tea or the naturally sweet and nutty flavor" +
                    " of our rooibos tea, our tea selection is sure to delight" +
                    " your senses and provide a relaxing and enjoyable experience with every sip."),
            Breakfast("Chocolate", 50,R.drawable.chocolate,"Indulge your sweet tooth with our " +
                    "selection of delectable chocolates. Our handcrafted chocolates are made with " +
                    "only the finest ingredients, including premium cocoa, fresh cream, " +
                    "and natural flavors. From classic milk and dark chocolates to unique" +
                    " and innovative flavors like sea salt caramel and espresso, our chocolates" +
                    " are sure to satisfy any chocolate lover's cravings. Treat yourself or" +
                    " someone special to the rich, creamy, and decadent flavors of our artisanal chocolates."),
            Breakfast("Cocoa", 50,R.drawable.cocoa,"" +
                    "cocoa, highly concentrated powder made from chocolate liquor—a paste " +
                    "prepared from cocoa beans, the fruit of the cacao—and used" +
                    " in beverages and as a flavouring ingredient. " +
                    "\nCocoa is the key ingredient in chocolate and chocolate confections." +
                    ""),
            Breakfast("Green Tea", 50,R.drawable.greentea,"" +
                    "Green tea is generally known to have lower caffeine content per cup than " +
                    "black tea and much lower caffeine content than coffee. " +
                    "\nLike all drinks cultivated from caffeinated plants, however, " +
                    "a specific level of caffeine per cup of green tea is hard to define as it will depend on" +
                    " the type of green tea as well as how is was processed and prepared." +
                    "Green Tea: Light and refreshing, green tea is known for its health benefits and is a great choice for an afternoon pick-me-up."),
            Breakfast("smoothie", 50,R.drawable.smoothie,"" +
                    "A breakfast smoothie offers hydration and nutrients in one convenient meal. " +
                    "\nFresh or frozen fruits provide vitamins and natural sweetness. " +
                    "\nSkim milk, soy milk or fat-free yogurt adds protein without excess fat. " +
                    "\nFor smoothies using fresh fruit, " +
                    "ice thickens the consistency and adds an extra element of hydration." +
                    ""),
            Breakfast("Milk", 50,R.drawable.milk,"" +
                    "The breakfast standby, milk, is usually a healthful breakfast drink. " +
                    "\nStick with an 8-ounce " +
                    "serving of either skim or soy milk to keep your breakfast low-calorie and low-fat. " +
                    "")
        )
LazyColumn(content = {
    items(breakfastlist.size){index ->
        Card(elevation = 2.dp,modifier = Modifier.padding(3.dp),onClick = { /*TODO*/ }) {
            Column {
                Card(modifier = Modifier.offset(5.dp), elevation = 4.dp){
Column (modifier = Modifier.padding(start = 80.dp,end = 30.dp)){
    Text(text = breakfastlist[index].name.uppercase(Locale.getDefault()),
        style = MaterialTheme.typography.h5,
    modifier = Modifier.offset (45.dp ))
    Spacer(modifier = Modifier.height(5.dp))
    Image(
        painter = painterResource(id = breakfastlist[index].image),

        contentDescription = breakfastlist[index].name,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(CircleShape)
            .size(180.dp)
    )
    Spacer(modifier = Modifier.height(7.dp))
    Text(
        text = "Price :   ${breakfastlist[index].price}",
        style = MaterialTheme.typography.subtitle1,
        modifier = Modifier.offset(50.dp)
    )
}
                }
                Spacer(modifier = Modifier.padding(top = 6.dp))
                Card(elevation = 4.dp) {
                    Column(modifier = Modifier.offset(10.dp,5.dp)) {
                        Text(
                            text = "Description",
                            style = MaterialTheme.typography.subtitle1,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(start = 120.dp,end = 10.dp,top =3.dp,bottom =10.dp)
                        )
                        Text(text = breakfastlist[index].description,
                        modifier = Modifier.padding(7.dp))
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
})
    }

}

@Preview
@Composable
fun  PreviewBev(){
    Beverages(navController = rememberNavController())
}