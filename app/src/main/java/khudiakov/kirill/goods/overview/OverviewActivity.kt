package khudiakov.kirill.goods.overview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import khudiakov.kirill.goods.R
import khudiakov.kirill.goods.databinding.ActivityOverviewBinding

class OverviewActivity : AppCompatActivity() {

    private lateinit var viewModel: OverviewViewModel
    private lateinit var binding: ActivityOverviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_overview)
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this)[OverviewViewModel::class.java]
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val viewAdapter = ProductsListAdapter(ProductsListAdapter.OnClickListener {})
        val viewManager = LinearLayoutManager(this)

        viewModel.products.observe(this, Observer { list ->
            viewAdapter.submitList(list)
        })

        binding.list.apply {
            layoutManager = viewManager
            adapter = viewAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }
}
