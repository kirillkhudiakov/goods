package khudiakov.kirill.goods.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a product stored in the database.
 */
@Entity
data class DatabaseProduct(
    @PrimaryKey var id: Long,
    var name: String,
    var price: Double,
    @ColumnInfo(name = "img_url") var imgUrl: String
)