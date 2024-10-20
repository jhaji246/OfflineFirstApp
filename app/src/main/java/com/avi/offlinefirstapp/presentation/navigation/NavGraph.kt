package com.avi.offlinefirstapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.avi.offlinefirstapp.presentation.ui.screen.UserScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "userScreen") {
        composable("userScreen") { UserScreen()}
    }
}