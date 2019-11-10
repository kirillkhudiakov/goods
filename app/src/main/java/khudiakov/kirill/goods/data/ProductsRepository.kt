package khudiakov.kirill.goods.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import khudiakov.kirill.goods.data.network.ProductsApi

/**
 * Repository class that encapsulates receiving product list from the server.
 */
class ProductsRepository {

    private var disposableObserver: Disposable? = null

    private val _products = MutableLiveData<List<Product>>()

    /**
     * List of products received from remote source.
     */
    val products: LiveData<List<Product>>
        get() = _products

    init {
        updateProducts()
    }

    /**
     * Update current product list via retrofit service.
     */
    private fun updateProducts() {
        val single = ProductsApi.retrofitService.getProducts()

        // Dispose previous disposable (if exists) to avoid memory leak.
        disposableObserver?.dispose()

        disposableObserver = single
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list ->
                _products.value = list
            }, {})
    }

    /**
     * Get product from repository with given id.
     * @param id Id of the product.
     * @return related product.
     */
    operator fun get(id: Long): Product? {
        return _products.value?.find { product ->
            product.id == id
        }
    }

    /**
     * Dispose related observer of network request.
     */
    fun clear() {
        disposableObserver?.dispose()
    }
}