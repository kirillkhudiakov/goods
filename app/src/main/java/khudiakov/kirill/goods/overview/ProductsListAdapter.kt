package khudiakov.kirill.goods.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import khudiakov.kirill.goods.data.Product
import khudiakov.kirill.goods.databinding.ListItemBinding

/**
 * Recycler view adapter for products.
 */
class ProductsListAdapter(private val clickListener: OnClickListener) :
    ListAdapter<Product, ProductsListAdapter.ProductViewHolder>(ProductDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    /**
     * View holder for product item.
     */
    class ProductViewHolder private constructor(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Bind specified product to layout.
         * @param product Product to bind.
         * @param clickListener Click listener of corresponding item.
         */
        fun bind(product: Product, clickListener: OnClickListener) {
            binding.product = product
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            /**
             * Create new view holder for item.
             * @param parent View group to which new view holder should be attached.
             * @return New view holder.
             */
            fun from(parent: ViewGroup): ProductViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ListItemBinding.inflate(inflater, parent, false)
                return ProductViewHolder(binding)
            }
        }
    }

    /**
     * Click listener for recycler view items.
     */
    class OnClickListener(private val clickListener: (product: Product) -> Unit) {
        fun onClick(product: Product) = clickListener(product)
    }

    /**
     * Product comparison object.
     */
    companion object ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }
}