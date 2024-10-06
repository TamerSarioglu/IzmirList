package com.tamersarioglu.izmirlist.presentation.screens.neighborhoodbazaarplacesscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.tamersarioglu.izmirlist.data.bazaardata.BazaarData
import com.tamersarioglu.izmirlist.presentation.Resource
import org.koin.androidx.compose.getViewModel

@Composable
fun NeighborhoodBazaarPlacesScreen(viewModel: NeighborhoodBazaarPlacesScreenViewModel = getViewModel()) {
    val bazaarState by viewModel.bazaarList.collectAsState()

    var isLoading by remember { mutableStateOf(true) }

    Column {
        when (bazaarState) {
            is Resource.Loading -> {
                isLoading = true
            }

            is Resource.Success -> {
                isLoading = false
                val bazaars = (bazaarState as Resource.Success<List<BazaarData>>).data

                bazaars.forEach { bazaar ->
                    Text(
                        text = bazaar.adi,
                        color = Color.Black
                    )
                }
            }

            is Resource.Error -> {
                isLoading = false
                Text(
                    text = (bazaarState as Resource.Error).message,
                    color = Color.Red
                )
            }
        }
    }
}