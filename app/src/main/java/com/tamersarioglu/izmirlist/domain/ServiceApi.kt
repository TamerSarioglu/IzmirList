package com.tamersarioglu.izmirlist.domain

import com.google.gson.annotations.SerializedName
import com.tamersarioglu.izmirlist.data.bazaardata.BazaarData
import com.tamersarioglu.izmirlist.data.wifiservicepointdata.WifiServicePointData
import retrofit2.http.GET

interface ServiceApi {
    @GET(ServiceApiConstants.WIFI_PLACES)
    suspend fun getWifiServices(): WifiResponseData

    @GET(ServiceApiConstants.NEIGHBORHOOD_BAZAAR_PLACES)
    suspend fun getNeighborhoodBazaarPlaces(): NeighborhoodBazaarResponseData
}

data class WifiResponseData(
    @SerializedName("onemliyer") val wifiServicesPlaces: List<WifiServicePointData>
)

data class NeighborhoodBazaarResponseData(
    @SerializedName("onemliyer") val neighborhoodBazaarPlaces: List<BazaarData>
)

object ServiceApiConstants {
    const val WIFI_PLACES = "wizmirnetnoktalari"
    const val NEIGHBORHOOD_BAZAAR_PLACES = "pazaryerleri"
}