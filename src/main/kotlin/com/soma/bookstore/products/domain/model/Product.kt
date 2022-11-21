package com.soma.bookstore.products.domain.model

import java.util.Date

data class Product(
    val id: String? = null,
    val title: String,
    val description: String,
    val language: String,
    val idNumber: String,
    val publicationDate: Date,
    val author: Author? = null,
    val category: Category? = null
)