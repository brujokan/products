package com.soma.bookstore.products.domain.model

data class Category(
    val id: String? = null,
    val name: String,
    val products: List<Product>? = null
)