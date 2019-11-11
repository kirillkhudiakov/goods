package khudiakov.kirill.goods.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import khudiakov.kirill.goods.R
import khudiakov.kirill.goods.adapters.ProductsListAdapter
import khudiakov.kirill.goods.data.PRODUCT_ID_KEY
import khudiakov.kirill.goods.data.ProductsRepository
import khudiakov.kirill.goods.databinding.ActivityOverviewBinding

class OverviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOverviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_overview)
        binding.lifecycleOwner = this

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val viewAdapter =
            ProductsListAdapter(ProductsListAdapter.OnClickListener { id ->
                navigateToDetailActivity(id)
            })
        val viewManager = LinearLayoutManager(this)

        ProductsRepository.products.observe(this, Observer { list ->
            viewAdapter.submitList(list)
        })

        binding.list.apply {
            layoutManager = viewManager
            adapter = viewAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

    private fun navigateToDetailActivity(productId: Long) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(PRODUCT_ID_KEY, productId)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }
}
