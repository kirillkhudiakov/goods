package khudiakov.kirill.goods.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import khudiakov.kirill.goods.R
import khudiakov.kirill.goods.data.ProductsRepository
import khudiakov.kirill.goods.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val id = intent.extras?.getLong("Key")
        id?.let {
            binding.product = ProductsRepository[id]
        }
    }
}
