package khudiakov.kirill.goods.data

/**
 * Represents a product received from the server.
 */
data class Product(
    var id: Long,
    var name: String,
    var price: Double,
    var imgUrl: String
)