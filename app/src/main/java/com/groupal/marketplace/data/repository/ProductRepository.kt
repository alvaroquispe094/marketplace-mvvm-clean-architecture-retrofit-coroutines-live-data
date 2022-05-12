package com.groupal.marketplace.data.repository

import com.groupal.marketplace.data.model.Category
import com.groupal.marketplace.data.model.Product
import com.groupal.marketplace.data.model.ProductProvider
import com.groupal.marketplace.data.service.ProductService
import javax.inject.Inject

class ProductRepository  @Inject constructor(
    private val api: ProductService,
    private val productProvider: ProductProvider
){
    suspend fun getAllProducts(): List<Product> {
        val response = api.getProducts()
        productProvider.products = response
        return response
    }

    suspend fun getProduct(id: String): Product {
        val response = api.getProduct(id)
        productProvider.product = response
        return response
    }

    suspend fun getMostRatedProducts(): List<Product> {
        val response = api.getMostRatedProducts()
        productProvider.products = response
        return response
    }

    suspend fun getAllCategories(): List<Category> {
        val response = api.getAllCategories()
        productProvider.categories = response
        return response
    }
}