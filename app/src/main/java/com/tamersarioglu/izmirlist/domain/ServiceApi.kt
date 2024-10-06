package com.tamersarioglu.izmirlist.domain

import com.google.gson.annotations.SerializedName
import com.tamersarioglu.izmirlist.data.wifiservicepointdata.WifiServicePointData
import retrofit2.http.GET

interface ServiceApi {
    @GET(ServiceApiConstants.WIFI_PLACES)
    suspend fun getWifiServices(): WifiResponseData
}

data class WifiResponseData(
    @SerializedName("onemliyer") val wifiServicesPlaces: List<WifiServicePointData>
)

object ServiceApiConstants {
    const val WIFI_PLACES = "api/ibb/cbs/wizmirnetnoktalari"
}