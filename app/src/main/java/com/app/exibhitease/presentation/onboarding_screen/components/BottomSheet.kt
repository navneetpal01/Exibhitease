package com.app.exibhitease.presentation.onboarding_screen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.exibhitease.R
import com.app.exibhitease.common.compose.UiButton
import com.app.exibhitease.ui.theme.color_bottomSheet
import com.app.exibhitease.ui.theme.poppins_Bold

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBottomSheet(
    state: BottomSheetScaffoldState,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {

    BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = state,
        sheetShape = RectangleShape,
        sheetContent = {
            SheetContent(
                onClick = onClick
            )
        },
        sheetDragHandle = {
            Row(
                modifier = Modifier
                    .height(15.dp)
                    .fillMaxWidth()
                    .background(color_bottomSheet),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(4.dp)
                        .background(Color(0xFF4E4B66), RoundedCornerShape(15.dp))
                        .padding(15.dp)
                )
            }
        },
    ) {
        content.invoke()
    }
}

@Composable
fun SheetContent(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color_bottomSheet),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.85f)
        ) {

            Text(
                text = "Uhmm... Can we have some of your permission?",
                color = Color(0xFFFCFCFC),
                fontSize = 30.sp,
                textAlign = TextAlign.Start,
                fontFamily = poppins_Bold
            )
            PermissionTab(
                modifier = Modifier
                    .padding(vertical = 15.dp)
            )
        }
        UiButton(
            onClick = onClick,
            modifier = Modifier
                .padding(bottom = 10.dp),
            text = "Sound exciting \uD83D\uDC4D"
        )
    }

}

@Composable
fun PermissionTab(
    modifier: Modifier = Modifier
) {
    val permission = listOf(
        Permission(
            icon = R.drawable.camera,
            heading = "Camera",
            description = "Allow us to use your camera for Displaying Art!"
        ),
        Permission(
            icon = R.drawable.picture,
            heading = "Gallery",
            description = "We need access to your gallery to upload Images"
        ),
        Permission(
            icon = R.drawable.locations,
            heading = "Location",
            description = "We need access to your location to provide location based services"
        )
    )
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color(0xFF4E4B66))
        )

        permission.forEach {
            PermissionUi(
                icon = it.icon,
                header = it.heading,
                desc = it.description
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color(0xFF4E4B66))
        )
    }
}

@Composable
fun PermissionUi(
    @DrawableRes icon: Int,
    header: String,
    desc: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(50.dp)
        )
        Column {
            Text(
                text = header
            )
            Text(
                text =desc
            )
        }
    }
}

private data class Permission(
    @DrawableRes val icon: Int,
    val heading: String,
    val description: String
)