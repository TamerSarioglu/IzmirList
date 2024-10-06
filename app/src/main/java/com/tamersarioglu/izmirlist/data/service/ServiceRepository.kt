package com.tamersarioglu.izmirlist.data.service

import com.tamersarioglu.izmirlist.data.bazaardata.BazaarData
import com.tamersarioglu.izmirlist.data.wifiservicepointdata.WifiServicePointData
import com.tamersarioglu.izmirlist.presentation.Resource
import kotlinx.coroutines.flow.Flow

interface ServiceRepository {
    fun getWifiLocationServiceData(): Flow<Resource<List<WifiServicePointData>>>
    fun getNeighborhoodBazaarPlacesData(): Flow<Resource<List<BazaarData>>>
}