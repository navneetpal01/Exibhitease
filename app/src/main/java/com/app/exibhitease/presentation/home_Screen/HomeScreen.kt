package com.app.exibhitease.presentation.home_Screen

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.exibhitease.presentation.permissions.PermissionViewModel


@Composable
fun HomeScreen(){
    val permissionViewModel : PermissionViewModel = viewModel()
    val permissions = arrayOf(
        Manifest.permission.LOCATION_HARDWARE,
        Manifest.permission.CAMERA,
    )
    val showDialog = permissionViewModel.showDialog.collectAsStateWithLifecycle()
    val launchAppSettings = permissionViewModel.launchAppSettings.collectAsStateWithLifecycle()
    val permissionResultActivityLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions(),
        onResult = {

        }
    )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){


        Text(
            text = "HomeScreen",
            fontSize = 30.sp,
            color = Color.Black
        )
    }
}