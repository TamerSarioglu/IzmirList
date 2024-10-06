package com.tamersarioglu.izmirlist.data.wifiservicepointdata

import com.google.gson.annotations.SerializedName

data class WifiServicePointData(
    @SerializedName("ILCE")
    val ilce: String,

    @SerializedName("ENLEM")
    val enlem: Double,

    @SerializedName("BOYLAM")
    val boylam: Double,

    @SerializedName("ADI")
    val adi: String,

    @SerializedName("MAHALLE")
    val mahalle: String,

    @SerializedName("YOL")
    val yol: String
)
