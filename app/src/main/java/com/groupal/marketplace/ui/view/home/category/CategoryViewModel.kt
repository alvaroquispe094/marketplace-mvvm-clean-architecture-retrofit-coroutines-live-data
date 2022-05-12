package com.groupal.marketplace.ui.view.home.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groupal.marketplace.data.model.Category
import com.groupal.marketplace.domain.CategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel  @Inject constructor(
    private val categoryUseCase: CategoryUseCase,
) : ViewModel() {

    val categories = MutableLiveData<List<Category>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
//            isLoading.postValue(true)
            val result = categoryUseCase()

            if (!result.isNullOrEmpty()) {
                categories.postValue(result)
//                isLoading.postValue(false)
            }
        }
    }
}