package com.groupal.marketplace.ui.view.home.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.groupal.marketplace.databinding.FragmentCategoryBinding
import com.groupal.marketplace.ui.view.home.productList.ProductListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : Fragment(), CategoryAdapter.OnItemClickListener {

    private lateinit var binding: FragmentCategoryBinding
    private val productListViewModel: CategoryViewModel by viewModels()

    private lateinit var mRecyclerView : RecyclerView
    private val adapter : CategoryAdapter = CategoryAdapter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        productListViewModel.onCreate()

//        fillItems();

        setupRecyclerView()
//
//        setUpObservers();

    }

     private fun fillItems(){
        // call method that fill mutableList
        productListViewModel.onCreate()

    }

    fun getAdapter(): CategoryAdapter {
        return this.adapter
    }

    private fun setupRecyclerView() {
        mRecyclerView = binding.list
        mRecyclerView.setHasFixedSize(true)

//        mAdapter.setMenus(it)

        mRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.adapter = adapter
    }

    private fun setUpObservers(){
        productListViewModel.categories.observe(viewLifecycleOwner, Observer {
            //setear datos en recyleView

            adapter.setItems(it)

        })
        productListViewModel.isLoading.observe(viewLifecycleOwner, Observer {
//            binding.loading.isVisible = it
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onResume() {
        super.onResume()
//        requestCharacters()
    }

    override fun onItemClick(category: String) {
        TODO("Not yet implemented")
    }

}