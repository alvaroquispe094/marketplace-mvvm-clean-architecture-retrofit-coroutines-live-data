package com.groupal.marketplace.data.model

import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductProvider @Inject constructor() {
    var products: List<Product> = Collections.emptyList()
    lateinit var product: Product
    var categories: List<Category> = Collections.emptyList()
}