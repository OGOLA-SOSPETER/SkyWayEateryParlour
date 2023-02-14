package com.example.skywayeatery.Tools

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.skywayeatery.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Slider(navController: NavHostController){
    val slideImage = remember { mutableStateOf(R.drawable.burgers_remov) }
    HorizontalPager(count = 3, state = PagerState()) { page ->
        when(page)  {

            0 -> {
                slideImage.value = R.drawable.grapes1
            }

            1 -> {
                slideImage.value = R.drawable.frrut
            }

            2 -> {
                slideImage.value = R.drawable.orange
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painterResource(slideImage.value),
                contentDescription = ""
            )
        }

    }

    Spacer(modifier = Modifier.padding(4.dp))

    DotsIndicator(
        totalDots = 3,
        selectedIndex = rememberPagerState(),
        selectedColor = Color.green(9),
        unSelectedColor = Color.green(5)
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: PagerState,
    selectedColor: Int,
    unSelectedColor: Int,
){

    LazyRow(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()

    ) {

        items(totalDots) { index ->
            if (index == selectedIndex.currentPage) {
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colors.primarySurface)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colors.primarySurface)
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}