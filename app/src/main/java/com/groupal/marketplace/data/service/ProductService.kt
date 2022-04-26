package com.groupal.marketplace.data.service

import com.groupal.marketplace.data.model.Product
import com.groupal.marketplace.data.model.Rating
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class ProductService @Inject constructor(private val api:IProductService){
    suspend fun getProducts(): List<Product> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllProducts()
            response.body() ?: Collections.emptyList()
        }
    }

    suspend fun getProduct(id: String): Product {
        return withContext(Dispatchers.IO) {
            val response = api.getProduct(id)
            if(response.code().toString() == "404"){
                Product(id = "",
                    title = "",
                    price = 0.0,
                    description = "",
                    category = "",
                    image = "",
                    rating=  Rating(
                        rate = 0.0,
                        count = 0
                    ),
                   )
            }else{
                response.body()!!
            }

        }
    }

    suspend fun getMostRatedProducts(): List<Product> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllProducts()

            //order list by rate
            val count = 5

            ((response.body()?.sortedByDescending { it.rating.rate }) ?: Collections.emptyList()).take(count)
        }
    }

    suspend fun getAllCategories(): List<String> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllCategories()
            response.body() ?: Collections.emptyList()
        }
    }
}