package khudiakov.kirill.goods.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Represents a product received from the server.
 */
@JsonClass(generateAdapter = true)
data class Product(
    @Json(name = "gcode") var id: Long,
    var name: String,
    var price: Double,
    @Json(name = "img_preview") var imgUrl: String
)