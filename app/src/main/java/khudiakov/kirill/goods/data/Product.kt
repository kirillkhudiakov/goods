package khudiakov.kirill.goods.data

/**
 * Domain class to represent a product.
 */
data class Product(
    var id: Long,
    var name: String,
    var price: Double,
    var imgUrl: String
)