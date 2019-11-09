package khudiakov.kirill.goods.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import khudiakov.kirill.goods.data.Product
import khudiakov.kirill.goods.data.ProductsApi

class OverviewViewModel : ViewModel() {

    private var disposableObserver: Disposable? = null

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    init {
        getProducts()
    }

    private fun getProducts() {
        val single = ProductsApi.retrofitService.getProducts()
        disposableObserver = single.subscribe({ response ->
            _products.value = response.body()
        }, {})
    }

    override fun onCleared() {
        super.onCleared()
        disposableObserver?.dispose()
    }
}