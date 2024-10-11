package com.app.exibhitease.presentation.onboarding_screen.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import com.app.exibhitease.ui.theme.color_bottomSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBottomSheet(
    state: BottomSheetScaffoldState,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = state,
        sheetShape = RectangleShape,
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.45f)
                    .background(color_bottomSheet)
            ) {

            }
        },
        sheetDragHandle = {

        },
    ) {
        content.invoke()
    }
}

@Composable
fun SheetContent(){

}