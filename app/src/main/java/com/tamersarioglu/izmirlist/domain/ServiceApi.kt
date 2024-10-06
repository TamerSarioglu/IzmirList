package com.tamersarioglu.izmirlist.domain

import com.google.gson.annotations.SerializedName
import com.tamersarioglu.izmirlist.data.bazaardata.BazaarData
import com.tamersarioglu.izmirlist.data.wifiservicepointdata.WifiServicePointData
import com.tamersarioglu.izmirlist.domain.responsedataclasses.ResponseDataClasses
import retrofit2.http.GET

interface ServiceApi {
    @GET(ServiceApiConstants.WIFI_PLACES)
    suspend fun getWifiServices(): ResponseDataClasses.WifiResponseData

    @GET(ServiceApiConstants.NEIGHBORHOOD_BAZAAR_PLACES)
    suspend fun getNeighborhoodBazaarPlaces(): ResponseDataClasses.NeighborhoodBazaarResponseData
}

object ServiceApiConstants {
    const val WIFI_PLACES = "wizmirnetnoktalari"
    const val NEIGHBORHOOD_BAZAAR_PLACES = "pazaryerleri"
}