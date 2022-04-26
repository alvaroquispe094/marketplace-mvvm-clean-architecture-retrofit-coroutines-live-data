package com.groupal.marketplace.ui.view.home.productList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.groupal.marketplace.R
import com.groupal.marketplace.data.model.Product
import com.groupal.marketplace.databinding.ItemProductListBinding

class ProductListAdapter (val listener: OnItemClickListener) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private var items = mutableListOf<Product>()
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_product_list, parent, false)
        return ViewHolder(view)
    }

    // Se setean los datos en las vista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.setIsRecyclable(false);
        val item = items[position]

        with(holder){
//            setListener(item)

            binding.productName.text = item.title

            Glide.with(mContext)
                    .load(item.image)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .into(binding.imgProduct)
        }
    }

    // Se setean los listeners de la vista
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemProductListBinding.bind(view)

    }

    override fun getItemCount(): Int = items.size

    fun setItems(products: List<Product>) {
        items.clear()
        items.addAll(products)
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClick(product: String)
    }
}