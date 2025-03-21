package com.assessment.staggeredgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.assessment.staggeredgrid.ui.theme.StaggeredGridTheme
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import kotlin.random.Random
import androidx.compose.foundation.lazy.staggeredgrid.*

//LazyHorizontalStaggeredGrid layout
data class BoxProperties(val color: Color, /*val height: Dp*/val width : Dp)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StaggeredGridTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val items = (1 .. 50).map {BoxProperties(//height = Random.nextInt(50, 200).dp,
                                                   ////LazyHorizontalStaggeredGrid layout
                                                   width = Random.nextInt(50, 200).dp,
                                                   color = Color(Random.nextInt(255),
                                                                 Random.nextInt(255),
                                                                 Random.nextInt(255),
                                                           255))
    }

    /*LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(3),
                              modifier = modifier.fillMaxSize(),
                              contentPadding = PaddingValues(8.dp),
                              horizontalArrangement = Arrangement.spacedBy(8.dp),
                              verticalItemSpacing = 8.dp) {
        items(items) { values -> GridItem(properties = values)}
    }*/

    LazyHorizontalStaggeredGrid (rows = StaggeredGridCells.Fixed(3),
                                 modifier = modifier.fillMaxSize(),
                                 contentPadding = PaddingValues(8.dp),
                                 horizontalItemSpacing = 8.dp,
                                 verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items) { values -> GridItem(properties = values)}
    }
}


@Composable
fun GridItem(properties: BoxProperties) {
    Box(modifier = Modifier.fillMaxWidth()
                           //.height(properties.height)
                           //LazyHorizontalStaggeredGrid layout
                           .width(properties.width)
                           .clip(RoundedCornerShape(10.dp))
                           .background(properties.color))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StaggeredGridTheme {
        MainScreen()
    }
}