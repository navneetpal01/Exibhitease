package com.app.exibhitease.common.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.exibhitease.ui.theme.poppins_semiBold
import com.app.exibhitease.ui.theme.shapphire_blue

@Composable
fun UiButton(
    onClick : () -> Unit,
    text : String,
    modifier: Modifier = Modifier
){

    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(0.85f),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = shapphire_blue),
        elevation = null,
        border = null,

        ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(vertical = 10.dp),
            color = Color.White,
            fontSize = 15.sp,
            fontFamily = poppins_semiBold,
        )
    }
}
