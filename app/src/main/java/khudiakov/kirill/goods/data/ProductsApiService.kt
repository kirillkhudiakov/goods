package khudiakov.kirill.goods.data

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://vimos.ru:1455"
private const val ENDPOINT = "products?cat_id=7&limit=10&offset=0&base_id=12&sort_type=0"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .baseUrl(BASE_URL)
    .build()

/**
 * Interface that contains methods for requesting data the server.
 */
interface ProductsApiService {

    /**
     * Requests a list of products from the server.
     * @return RxJava Single object.
     */
    @GET(ENDPOINT)
    fun getProducts(): Single<List<Product>>
}

/**
 * Singleton that contains a reference to retrofit service.
 */
object ProductsApi {
    val retrofitService : ProductsApiService by lazy {
        retrofit.create(ProductsApiService::class.java)
    }
}