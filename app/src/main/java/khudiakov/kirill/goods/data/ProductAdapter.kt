package khudiakov.kirill.goods.data

import com.squareup.moshi.FromJson
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.ToJson

/**
 * img_preview field received from json doesn't contain full url of image, only endpoint.
 * That's why we need to create custom converter adapter and intermediate class.
 */

/**
 * Intermediate class representing a converted Json object.
 */
@JsonClass(generateAdapter = true)
data class ProductJson(
    @Json(name = "gcode") var id: Long,
    var name: String,
    var price: Double,
    @Json(name = "img_preview") var imgUrlEndpoint: String
)

/**
 * Moshi adapter for converting ProductJson to Product and vice versa.
 */
class ProductAdapter {
    @FromJson
    fun productFromJson(productJson: ProductJson): Product {
        return Product(
            productJson.id,
            productJson.name,
            productJson.price,
            BASE_URL + productJson.imgUrlEndpoint
        )
    }

    @ToJson
    fun productToJson(product: Product): ProductJson {
        return ProductJson(
            product.id,
            product.name,
            product.price,
            product.imgUrl.substring(BASE_URL.length)
        )
    }
}