package com.groupal.marketplace.ui.view.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.groupal.marketplace.R
import com.groupal.marketplace.databinding.ActivityHomeBinding
import com.groupal.marketplace.ui.view.home.category.CategoryFragment
import com.groupal.marketplace.ui.view.home.category.CategoryViewModel
import com.groupal.marketplace.ui.view.home.search.SearchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val categoryViewModel: CategoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load navigation fragment
//        loadNavigation()

        // Load search fragment
        loadSearch();

        // Load banner slider fragment
//        loadBannerSlider()

        //Load category slider fragment
        if(savedInstanceState == null){
            loadCategorySlider()
        }




    }

    private fun loadCategorySlider() {
        val fragment = CategoryFragment()

        this.supportFragmentManager
                .beginTransaction()
                .add(R.id.homeContainer, fragment)
                .commit()

    }

    private fun loadSearch() {
        val fragment = SearchFragment()

        this.supportFragmentManager
                .beginTransaction()
                .add(R.id.homeContainer, fragment)
                .commit()

    }


}