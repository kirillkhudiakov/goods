package khudiakov.kirill.goods.data

import io.reactivex.Single
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://vimos.ru:1455"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ProductsApiService {
    @GET("products?cat_id=7&limit=10&offset=0&base_id=12&sort_type=0")
    fun getProducts(): Single<Response<List<Product>>>
}

object ProductsApi {
    val retrofitService : ProductsApiService by lazy {
        retrofit.create(ProductsApiService::class.java)
    }
}