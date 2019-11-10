package khudiakov.kirill.goods.data

import com.squareup.moshi.FromJson
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.ToJson

@JsonClass(generateAdapter = true)
data class ProductJson(
    @Json(name = "gcode") var id: Long,
    var name: String,
    var price: Double,
    @Json(name = "img_preview") var imgUrl: String
)

class ProductAdapter {
    @FromJson
    fun productFromJson(productJson: ProductJson): Product {
        return Product(
            productJson.id,
            productJson.name,
            productJson.price,
            BASE_URL + productJson.imgUrl
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