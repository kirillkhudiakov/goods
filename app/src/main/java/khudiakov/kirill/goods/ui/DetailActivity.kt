package khudiakov.kirill.goods.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import khudiakov.kirill.goods.R
import khudiakov.kirill.goods.data.PRODUCT_ID_KEY
import khudiakov.kirill.goods.data.ProductsRepository
import khudiakov.kirill.goods.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        intent.extras?.getLong(PRODUCT_ID_KEY)?.let { id ->
            binding.product = ProductsRepository[id]
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}
