package com.tamersarioglu.izmirlist.domain.responsedataclasses

import com.google.gson.annotations.SerializedName
import com.tamersarioglu.izmirlist.data.bazaardata.BazaarData
import com.tamersarioglu.izmirlist.data.wifiservicepointdata.WifiServicePointData

object ResponseDataClasses {
    data class WifiResponseData(
        @SerializedName("onemliyer") val wifiServicesPlaces: List<WifiServicePointData>
    )

    data class NeighborhoodBazaarResponseData(
        @SerializedName("onemliyer") val neighborhoodBazaarPlaces: List<BazaarData>
    )
}