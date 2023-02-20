import com.example.skywayeateryparlour.R

data class Breakfasts(val description: String, val price: Float, val image: Int)
val breaklist = listOf(
    Breakfasts("Black Tea",200.50F,R.drawable.blacktea),
    Breakfasts("Black Hot Coffee",250.00F,R.drawable.blackcoffee),
    Breakfasts("Green Tea \nWith Lemon",230.00F,R.drawable.greentea),
    Breakfasts("Black Chocolate",230.00F,R.drawable.blackchocolate),
    Breakfasts("White Tea",500.00F,R.drawable.whitetea)
)


data class Fresh(val description: String, val price: Float, val image: Int)
val freshList = listOf(
    Fresh("Mangoes",59.67F, R.drawable.mango),
    Fresh("Orange",120.50F, R.drawable.orange),
    Fresh("Passion",230.00F, R.drawable.passion),
    Fresh("Red Apple",210.59F, R.drawable.red_apple),
    Fresh("PineApple",178.90F, R.drawable.pineapple)
)



data class Lunch(val description: String, val price: Float, val image: Int)
val lunchlist = listOf(
    Lunch("Fried Meat",470.50F, R.drawable.friedmeat),
    Lunch("Roasted Meat",350.50F, R.drawable.meat),
    Lunch("French Dish",550.00F, R.drawable.frenchdish),
    Lunch("Mukimo",150.00F, R.drawable.mukimo),
    Lunch("Matoke",250.50F, R.drawable.matoke)
)