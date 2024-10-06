package com.tamersarioglu.izmirlist.data.service

import com.tamersarioglu.izmirlist.data.wifiservicepointdata.WifiServicePointData
import com.tamersarioglu.izmirlist.domain.ServiceApi
import com.tamersarioglu.izmirlist.presentation.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ServiceRepositoryImpl(private val api: ServiceApi) : ServiceRepository {
    override fun getWifiLocationServiceData(): Flow<Resource<List<WifiServicePointData>>> = flow {
        emit(Resource.Loading)
        try {
            val response = api.getWifiServices()
            val distinctWifiServices = response.wifiServicesPlaces.distinctBy { it.ADI }
            emit(Resource.Success(distinctWifiServices))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown error"))
        }
    }
}
