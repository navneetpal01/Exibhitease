package com.app.exibhitease

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.app.exibhitease.ui.theme.ExibhiteaseTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )
        setContent {
            ExibhiteaseTheme {

            }
        }
    }


}


@Composable
fun Menu(
    modifier: Modifier
) {

    val currentIndex by remember { mutableStateOf(0) }

    val itemsList = listOf(
        Food("burger", R.drawable.burger),
        Food("instant", R.drawable.instant),
        Food("momos", R.drawable.momos),
        Food("pizza", R.drawable.pizza),
        Food("ramen", R.drawable.ramen),
    )
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        IconButton(
            onClick = {

            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                contentDescription = "previous"
            )
        }

        CircularImage(modifier = , imageId = )

        IconButton(
            onClick = {

            },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = "next"
            )
        }
    }
}

@Composable
fun CircularImage(
    modifier: Modifier = Modifier,
    imageId: Int,

) {
    Box(
        modifier = modifier
            .size(140.dp)
            .clip(CircleShape)
            .border(width = 3.dp, color = androidx.compose.ui.graphics.Color(0x9E1F1F1F))
    ){
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "null",
            contentScale = ContentScale.FillBounds
        )
    }
}



data class Food(
    var name: String,
    var imageId: Int
)