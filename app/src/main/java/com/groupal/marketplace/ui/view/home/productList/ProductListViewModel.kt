package com.groupal.marketplace.ui.view.home.productList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groupal.marketplace.data.model.Product
import com.groupal.marketplace.domain.ProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
        private val productsUseCase: ProductsUseCase,
) : ViewModel() {

    val products = MutableLiveData<List<Product>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = productsUseCase()

            if (!result.isNullOrEmpty()) {
                products.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

}