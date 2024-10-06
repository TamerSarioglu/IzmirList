package com.tamersarioglu.izmirlist.presentation.screens.wifiservicelocationlistscreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tamersarioglu.izmirlist.components.CircularIndicator
import com.tamersarioglu.izmirlist.components.WifiServicePointDataCard
import com.tamersarioglu.izmirlist.data.wifiservicepointdata.WifiServicePointData
import com.tamersarioglu.izmirlist.presentation.Resource
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WifiServiceLocationListScreen(viewModel: WifiServiceLocationListScreenViewModel = getViewModel()) {

    val wifiServiceState by viewModel.wifiServiceList.collectAsState()

    var isLoading by remember { mutableStateOf(true) }
    var searchQuery by remember { mutableStateOf("") }

    Column {

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { query -> searchQuery = query },
            label = { Text("Search by Neighborhood") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            singleLine = true
        )

        when (wifiServiceState) {
            is Resource.Loading -> {
                isLoading = true
            }
            is Resource.Success -> {
                isLoading = false
                val services = (wifiServiceState as Resource.Success<List<WifiServicePointData>>).data

                // Filter the services by neighborhood based on the search query
                val filteredServices = if (searchQuery.isEmpty()) {
                    services
                } else {
                    services.filter { it.mahalle.contains(searchQuery, ignoreCase = true) }
                }

                // Group services by name (or any other field)
                val groupedServices = filteredServices.groupBy { it.mahalle }

                LazyColumn {
                    groupedServices.forEach { (name, serviceList) ->
                        // Sticky header for each group
                        stickyHeader {
                            Text(
                                text = name, // Display the group name (header)
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.LightGray)
                                    .padding(8.dp),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        }

                        // List items under each header
                        items(serviceList) { service ->
                            WifiServicePointDataCard(service = service)
                        }
                    }
                }
            }
            is Resource.Error -> {
                isLoading = false
                Text(
                    text = (wifiServiceState as Resource.Error).message,
                    color = Color.Red,
                )
            }
        }

        AnimatedVisibility(
            visible = isLoading,
            exit = fadeOut(animationSpec = tween(durationMillis = 1000)) // 1-second fade-out
        ) {
            CircularIndicator()
        }
    }
}



