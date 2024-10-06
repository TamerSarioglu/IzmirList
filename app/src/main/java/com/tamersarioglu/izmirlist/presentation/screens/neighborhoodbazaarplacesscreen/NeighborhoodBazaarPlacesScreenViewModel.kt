package com.tamersarioglu.izmirlist.presentation.screens.neighborhoodbazaarplacesscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamersarioglu.izmirlist.data.bazaardata.BazaarData
import com.tamersarioglu.izmirlist.presentation.Resource
import com.tamersarioglu.izmirlist.presentation.usecases.GetBazaarLocationsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NeighborhoodBazaarPlacesScreenViewModel(
    private val getBazaarLocationsUseCase: GetBazaarLocationsUseCase) : ViewModel() {

    private val _bazaarList = MutableStateFlow<Resource<List<BazaarData>>>(Resource.Loading)
    val bazaarList: StateFlow<Resource<List<BazaarData>>> = _bazaarList

    init {
        loadBazaarLocations()
    }

    private fun loadBazaarLocations() {
        viewModelScope.launch {
            getBazaarLocationsUseCase()
                .collect { result ->
                    _bazaarList.value = result
                }
        }
    }
}