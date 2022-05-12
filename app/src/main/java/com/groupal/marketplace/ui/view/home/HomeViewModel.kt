package com.groupal.marketplace.ui.view.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groupal.marketplace.data.model.Category
import com.groupal.marketplace.data.model.Product
import com.groupal.marketplace.domain.CategoryUseCase
import com.groupal.marketplace.domain.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productsUseCase: ProductsUseCase,
    private val categoryUseCase: CategoryUseCase,
) : ViewModel() {

    val products = MutableLiveData<List<Product>>()
    val categories = MutableLiveData<List<Category>>()
    val isLoading = MutableLiveData<Boolean>()
//    val productListViewModel: ProductListViewModel by viewModels()

    fun onGetCategories(){
        var response:List<Category>
        viewModelScope.launch {
//            isLoading.postValue(true)
            var result = categoryUseCase()
            categories.postValue(result)

        }
    }

    fun onGetProducts(){
        viewModelScope.launch {
//            isLoading.postValue(true)
            val result = productsUseCase()

//            if (!result.isNullOrEmpty()) {
                products.postValue(result)
////                isLoading.postValue(false)
//            }
        }
    }

    fun fillHome(){
        viewModelScope.launch {
            isLoading.postValue(true)

            var result = categoryUseCase()
            categories.postValue(result)
            val result2 = productsUseCase()
            products.postValue(result2)

            if (!result.isNullOrEmpty() && !result2.isNullOrEmpty()) {
                isLoading.postValue(false)
            }

        }
    }

}