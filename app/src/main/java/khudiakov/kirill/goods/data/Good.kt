package khudiakov.kirill.goods.data

/**
 * Domain class to represent a good.
 */
data class Good(
    var id: Long,
    var name: String,
    var price: Double,
    var imgUrl: String
)