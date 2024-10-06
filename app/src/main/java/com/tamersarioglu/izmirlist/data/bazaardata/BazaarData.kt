package com.tamersarioglu.izmirlist.data.bazaardata

import com.google.gson.annotations.SerializedName

data class BazaarData(
    @SerializedName("ILCE")
    val ilce: String,

    @SerializedName("KAPINO")
    val kapino: String,

    @SerializedName("ENLEM")
    val enlem: Double,

    @SerializedName("ACIKLAMA")
    val aciklama: String,

    @SerializedName("ILCEID")
    val ilceId: String,

    @SerializedName("MAHALLE")
    val mahalle: String,

    @SerializedName("MAHALLEID")
    val mahalleId: String?,

    @SerializedName("ADI")
    val adi: String,

    @SerializedName("BOYLAM")
    val boylam: Double,

    @SerializedName("YOL")
    val yol: String
)
