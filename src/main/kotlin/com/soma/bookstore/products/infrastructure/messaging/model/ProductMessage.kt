package com.soma.bookstore.products.infrastructure.messaging.model

data class ProductMessage(
    val id: String,
    val title: String,
    val language: String,
    val idNumber: String,
    val author: String,
    val category: String
)
