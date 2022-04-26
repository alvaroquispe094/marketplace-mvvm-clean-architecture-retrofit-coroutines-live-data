package com.groupal.marketplace.domain

import com.groupal.marketplace.data.repository.ProductRepository
import javax.inject.Inject

class ProductsUseCase  @Inject constructor(private val repository: ProductRepository){
    suspend operator fun invoke() = repository.getAllProducts()
}