package com.app.exibhitease.presentation.home_Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.overscroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.exibhitease.R
import com.app.exibhitease.ui.theme.poppins_Bold
import com.app.exibhitease.ui.theme.poppins_light
import com.app.exibhitease.ui.theme.poppins_medium
import com.app.exibhitease.ui.theme.poppins_regular
import com.app.exibhitease.ui.theme.poppins_semiBold
import com.app.exibhitease.ui.theme.shapphire_blue
import com.app.exibhitease.ui.theme.system_black
import com.app.exibhitease.ui.theme.system_white


@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopComponent()
    }
}

@Composable
fun TopComponent(
    modifier: Modifier = Modifier
) {
    val list = listOf("Portraits","Sci-Fi","Pop Culture","Nature","Fantasy","Historical")
    Column(
        modifier = modifier
            .fillMaxWidth(0.95f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Explore",
                fontSize = 18.sp,
                fontFamily = poppins_regular,
                color = system_black
            )

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.place),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp),
                    tint = shapphire_blue
                )
                Text(
                    text = "Solara, Nexus",
                    fontSize = 12.sp,
                    fontFamily = poppins_light,
                    color = system_black
                )
                Icon(
                    painter = painterResource(id = R.drawable.arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp),
                    tint = shapphire_blue
                )
            }
        }
        Text(
            text = "ArtVerse",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Start,
            fontSize = 30.sp,
            fontFamily = poppins_medium,
            color = system_black
        )
        Row(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFD7D9DC), RoundedCornerShape(20.dp))
                .shadow(elevation = 0.dp, shape = RoundedCornerShape(20.dp)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            Icon(
                painter = painterResource(id = R.drawable.search),
                modifier = Modifier
                    .size(40.dp)
                    .padding(start = 10.dp),
                contentDescription = null,
                tint = Color(0xFF9CA1A7)
            )
            Text(
                text = "Search Creations...",
                modifier = Modifier
                    .padding(vertical = 18.dp),
                fontSize = 20.sp,
                fontFamily = poppins_medium,
                color = Color(0xFF9CA1A7),
                maxLines = 1
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .scrollable(
                    orientation = Orientation.Horizontal,
                    state = ScrollableState { it }
                ),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            items(list){
                ActionChips(text = it)
            }
        }
    }

}

@Composable
fun ActionChips(
    text : String
){
    ElevatedFilterChip(
        selected = false,
        onClick = { /*TODO*/ },
        label = {
            Text(
                text = text,
                modifier = Modifier
                    .padding(vertical = 10.dp),
                fontSize = 15.sp,
                fontFamily = poppins_semiBold,
            )
        },
        colors = SelectableChipColors(
            containerColor = system_white,
            labelColor = shapphire_blue,
            leadingIconColor = system_white,
            trailingIconColor = system_white,
            disabledContainerColor = system_white,
            disabledLabelColor = system_white,
            disabledLeadingIconColor = system_white,
            disabledTrailingIconColor = system_white,
            selectedContainerColor = system_white,
            disabledSelectedContainerColor = system_white,
            selectedLabelColor = system_white,
            selectedLeadingIconColor = system_white,
            selectedTrailingIconColor = system_white
        ),
        shape = CircleShape
    )
}
