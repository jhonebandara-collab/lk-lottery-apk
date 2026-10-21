package com.lklotterymaster.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ResultsScreen(language: String) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Results Screen", style = MaterialTheme.typography.headlineMedium)
        Text("Language: $language", style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun HistoryScreen(language: String) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Scan History", style = MaterialTheme.typography.headlineMedium)
        Text("Language: $language", style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun LuckyGuessScreen(language: String) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Lucky Guess", style = MaterialTheme.typography.headlineMedium)
        Text("Language: $language", style = MaterialTheme.typography.bodyLarge)
    }
}
