package com.groupal.marketplace.ui.view.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import com.groupal.marketplace.R
import com.groupal.marketplace.databinding.ActivityHomeBinding
import com.groupal.marketplace.ui.view.home.category.CategoryFragment
import com.groupal.marketplace.ui.view.home.productList.ProductListFragment
import com.groupal.marketplace.ui.view.home.search.SearchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    private lateinit var  searchFragment:SearchFragment
    private lateinit var  categoryFragment:CategoryFragment
    private lateinit var productListFragment:ProductListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            //show loading spinner and opaque view
//            binding.scrollContainer.alpha = 0.0f
//            productListViewModel.isLoading.postValue(true)
//
//            productListViewModel.onCreate()
//
//            productListViewModel.isLoading.observe(this, Observer {
//                binding.loading.isVisible = it
//                if(!it){
//                    binding.scrollContainer.alpha = 1.0F
//                }
//
//            })
//
//            binding.scrollContainer.alpha = 0.0f
//            homeViewModel.isLoading.postValue(false)

            loadFragments();
            fillHome()
            setUpObservers()
        }

    }

    private fun fillHome(){
        homeViewModel.fillHome()
    }

    private fun setUpObservers(){
        homeViewModel.products.observe(this, Observer {
            productListFragment.getAdapter().setItems(it)
        })

        homeViewModel.categories.observe(this, Observer {
            categoryFragment.getAdapter().setItems(it)
        })

        homeViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
            if(!it){
                binding.scrollContainer.alpha = 1.0F
            }else{
                binding.scrollContainer.alpha = 0.0f
            }
        })
    }

    private fun loadFragments(){
        val fm: FragmentManager = supportFragmentManager
        searchFragment = SearchFragment()
        categoryFragment = CategoryFragment()
        productListFragment = ProductListFragment()
        // Load search fragment
        fm.beginTransaction().add(R.id.homeContainer, searchFragment).commit()
        // Load slider of categories
        fm.beginTransaction().add(R.id.homeContainer, categoryFragment).commit()
        // Load grid of products
        fm.beginTransaction().add(R.id.homeContainer, productListFragment).commit()
    }
}
