package com.soma.bookstore.products.infrastructure.persistence.collection

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "author")
data class AuthorCollection(
    val id: String? = null,
    val name: String,
    val description: String,
    val products: List<ProductCollection>? = null
)
