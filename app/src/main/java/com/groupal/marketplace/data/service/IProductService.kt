package com.groupal.marketplace.data.service

import com.groupal.marketplace.data.model.Category
import com.groupal.marketplace.data.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IProductService {
    @GET("/product")
    suspend fun getAllProducts(): Response<List<Product>>

    @GET("/product/{id}")
    suspend fun getProduct(@Path("id") id: String): Response<Product>

    @GET("/category")
    suspend fun getAllCategories(): Response<List<Category>>
}