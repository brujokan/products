package com.soma.bookstore.products.products.domain.model

data class Author(
    val id: String? = null,
    val name: String,
    val description: String,
    val products: List<Product>? = null
)
