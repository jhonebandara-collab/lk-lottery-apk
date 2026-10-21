package com.lklotterymaster.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

data class NavigationItem(
    val route: String,
    val icon: ImageVector,
    val labelEn: String,
    val labelSi: String,
    val labelTa: String
)

@Composable
fun BottomNavigationBar(navController: NavController, language: String) {
    val items = listOf(
        NavigationItem("scanner", Icons.Default.QrCodeScanner, "Scanner", "ස්කෑනර්", "ஸ்கேனர்"),
        NavigationItem("results", Icons.Default.FormatListBulleted, "Results", "ප්‍රතිඵල", "முடிவுகள்"),
        NavigationItem("history", Icons.Default.History, "History", "ඉතිහාසය", "வரலாறு"),
        NavigationItem("lucky", Icons.Default.Star, "Lucky", "වාසනා", "அதிர்ஷ்டம்")
    )

    NavigationBar {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.labelEn) },
                label = { 
                    val label = when (language) {
                        "si" -> item.labelSi
                        "ta" -> item.labelTa
                        else -> item.labelEn
                    }
                    Text(label) 
                },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
