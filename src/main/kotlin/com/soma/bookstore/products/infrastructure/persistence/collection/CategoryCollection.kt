package com.soma.bookstore.products.infrastructure.persistence.collection

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "category")
data class CategoryCollection(
    val id: String? = null,
    val name: String,
    val products: List<ProductCollection>? = null
)
