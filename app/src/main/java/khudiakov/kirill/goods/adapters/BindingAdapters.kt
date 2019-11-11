package khudiakov.kirill.goods.adapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import khudiakov.kirill.goods.R
import khudiakov.kirill.goods.data.ProductsApiStatus

@BindingAdapter("circleImageUrl")
fun bindCircleImage(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        Glide.with(imageView.context)
            .load(imageUrl)
            .circleCrop()
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imageView)
    }
}

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        Glide.with(imageView.context)
            .load(imageUrl)
            .into(imageView)
    }
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: ProductsApiStatus?) {
    when(status) {
        ProductsApiStatus.LOADING -> {
            statusImageView.apply {
                visibility = View.VISIBLE
                setImageResource(R.drawable.loading_animation)
            }
        }
        ProductsApiStatus.ERROR -> {
            statusImageView.apply {
                visibility = View.VISIBLE
                setImageResource(R.drawable.ic_connection_error)
            }
        }
        ProductsApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}