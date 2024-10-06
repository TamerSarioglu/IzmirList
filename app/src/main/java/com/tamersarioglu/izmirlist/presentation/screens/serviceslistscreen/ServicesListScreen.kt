package com.tamersarioglu.izmirlist.presentation.screens.serviceslistscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.tamersarioglu.izmirlist.presentation.screens.WifiServiceLocationListScreen

@Composable
fun ServicesListScreen(navController: NavHostController) {
    val servicesList = listOf(
        "WizmirNET Ücretsiz İnternet Noktaları",
        "Semt Pazar Yerleri"
    )
    ServicesListScreenContent(servicesList = servicesList, onItemClick = {
        navController.navigate(WifiServiceLocationListScreen.ROUTE)
    })
}

@Composable
fun ServicesListScreenContent(servicesList: List<String>, onItemClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        servicesList.forEach { service ->
            ServiceListItem(service = service, onClick = { onItemClick(service) })
        }
    }
}

@Composable
fun ServiceListItem(service: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Text(modifier = Modifier.padding(8.dp), text = service)
    }
}

