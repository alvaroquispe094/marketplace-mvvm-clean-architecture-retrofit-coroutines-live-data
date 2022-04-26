package com.groupal.marketplace.ui.view.home.productList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.groupal.marketplace.R
import com.groupal.marketplace.databinding.FragmentCategoryBinding
import com.groupal.marketplace.databinding.FragmentProductListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment(), ProductListAdapter.OnItemClickListener {

    private lateinit var binding: FragmentProductListBinding
    private val productListViewModel: ProductListViewModel by viewModels()

    private lateinit var mRecyclerView : RecyclerView
    private val adapter : ProductListAdapter = ProductListAdapter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fillItems();
        setupRecyclerView()
        setUpObservers();

    }

    private fun fillItems(){
        // call method that fill mutableList
        productListViewModel.onCreate()

    }

    private fun setupRecyclerView() {
        mRecyclerView = binding.listProduct
        mRecyclerView.setHasFixedSize(true)
//        mRecyclerView.isNestedScrollingEnabled = false;
//        mRecyclerView.smoothScrollToPosition(0)
        mRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2);
        mRecyclerView.adapter = adapter
    }

    private fun setUpObservers(){
        productListViewModel.products.observe(viewLifecycleOwner, Observer {
            //setear datos en recyleView

            adapter.setItems(it)

        })
        productListViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.loading.isVisible = it
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onResume() {
        super.onResume()
//        requestCharacters()
    }

    override fun onItemClick(product: String) {
        TODO("Not yet implemented")
    }

}