package com.lklotterymaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lklotterymaster.ui.theme.LKLotteryMasterTheme
import com.lklotterymaster.ui.screens.ScannerScreen
import com.lklotterymaster.ui.screens.ResultsScreen
import com.lklotterymaster.ui.screens.HistoryScreen
import com.lklotterymaster.ui.screens.LuckyGuessScreen
import com.lklotterymaster.ui.components.BottomNavigationBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var currentLanguage by remember { mutableStateOf("si") }
            
            LKLotteryMasterTheme {
                val navController = rememberNavController()
                
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigationBar(navController = navController, language = currentLanguage)
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "scanner",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("scanner") {
                            ScannerScreen(language = currentLanguage)
                        }
                        composable("results") {
                            ResultsScreen(language = currentLanguage)
                        }
                        composable("history") {
                            HistoryScreen(language = currentLanguage)
                        }
                        composable("lucky") {
                            LuckyGuessScreen(language = currentLanguage)
                        }
                    }
                }
            }
        }
    }
}
