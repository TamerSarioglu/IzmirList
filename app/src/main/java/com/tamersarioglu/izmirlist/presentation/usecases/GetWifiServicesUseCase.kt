package com.tamersarioglu.izmirlist.presentation.usecases

import com.tamersarioglu.izmirlist.data.service.ServiceRepository
import com.tamersarioglu.izmirlist.data.wifiservicepointdata.WifiServicePointData
import com.tamersarioglu.izmirlist.presentation.Resource
import kotlinx.coroutines.flow.Flow

class GetWifiServicesUseCase(private val repository: ServiceRepository) {
    operator fun invoke(): Flow<Resource<List<WifiServicePointData>>> {
        return repository.getWifiLocationServiceData()
    }
}