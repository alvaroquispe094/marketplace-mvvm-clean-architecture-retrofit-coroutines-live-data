package com.groupal.marketplace.ui.view.home.category

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.groupal.marketplace.R
import com.groupal.marketplace.databinding.ItemCategoryBinding

class CategoryAdapter(val listener: OnItemClickListener) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var items = mutableListOf<String>()
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    // Se setean los datos en las vista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        with(holder){
//            setListener(item)

            binding.labelCategory.text = item

//            Glide.with(mContext).asBitmap()
//                .load(R.mipmap.ic_launcher)
//                .into(binding.iconCategory)
        }
    }

    // Se setean los listeners de la vista
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemCategoryBinding.bind(view)

//        fun setListener(storeEntity: StoreEntity){
//            with(binding.root) {
//                setOnClickListener { listener.onClick(storeEntity.id) }
//                setOnLongClickListener {
//                    listener.onDeleteStore(storeEntity)
//                    true
//                }
//            }
//
//            binding.cbFavorite.setOnClickListener{
//                listener.onFavoriteStore(storeEntity)
//            }
//        }
    }

    override fun getItemCount(): Int = items.size

    fun setItems(categories: List<String>) {
        items.clear()
        items.addAll(categories)
        notifyDataSetChanged()
    }
//
//    fun add(storeEntity: StoreEntity) {
//        if (!stores.contains(storeEntity)) {
//            stores.add(storeEntity)
//            notifyItemInserted(stores.size-1)
//        }
//    }
//
//    fun update(storeEntity: StoreEntity) {
//        val index = stores.indexOf(storeEntity)
//        if (index != -1){
//            stores.set(index, storeEntity)
//            notifyItemChanged(index)
//        }
//    }
//
//    fun delete(storeEntity: StoreEntity) {
//        val index = stores.indexOf(storeEntity)
//        if (index != -1){
//            stores.removeAt(index)
//            notifyItemRemoved(index)
//        }
//    }

    interface OnItemClickListener {
        fun onItemClick(category: String)
    }
}


