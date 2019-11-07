package khudiakov.kirill.goods.data.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkGood(
    @Json(name = "gcode") var id: Long,
    var name: String,
    var price: Double,
    @Json(name = "img_preview") var imgUrl: String
)