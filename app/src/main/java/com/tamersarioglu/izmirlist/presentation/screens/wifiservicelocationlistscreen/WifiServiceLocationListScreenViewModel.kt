package com.tamersarioglu.izmirlist.presentation.screens.wifiservicelocationlistscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamersarioglu.izmirlist.data.wifiservicepointdata.WifiServicePointData
import com.tamersarioglu.izmirlist.presentation.Resource
import com.tamersarioglu.izmirlist.presentation.usecases.GetWifiServicesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WifiServiceLocationListScreenViewModel(
    private val getServicesUseCase: GetWifiServicesUseCase) : ViewModel() {

    private val _wifiServiceList =
        MutableStateFlow<Resource<List<WifiServicePointData>>>(Resource.Loading)
    val wifiServiceList: StateFlow<Resource<List<WifiServicePointData>>> = _wifiServiceList

    init {
        loadServices()
    }

    private fun loadServices() {
        viewModelScope.launch {
            getServicesUseCase()
                .collect { result ->
                    _wifiServiceList.value = result
                }
        }
    }
}