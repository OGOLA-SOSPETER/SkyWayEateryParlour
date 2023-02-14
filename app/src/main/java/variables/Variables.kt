package variables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.skywayeatery.R

@Composable
fun variables() {
    val image = painterResource(R.drawable.burgers_remov).apply {
        val rainbowColorsBrush = remember {
            Brush.sweepGradient(
                listOf(
                    Color(0xFF815DC0),
                    Color(0xFFBA68C8),
                    Color(0xFFE57373),
                    Color(0xFFFFB74D),
                    Color(0xFFFFF176),
                    Color(0xFFAED581),
                    Color(0xFF4DD0E1),
                    Color(0xFF9575CD)
                )
            )
        }
    }
}