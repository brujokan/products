package com.soma.bookstore.products.infrastructure.persistence.collection

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "product")
data class ProductCollection(
    @Id
    val id: String? = null,
    val title: String,
    val description: String,
    val language: String,
    @Indexed(name = "id_number")
    val idNumber: String,
    @Indexed(name = "publication_date")
    val publicationDate: Date,
    val author: AuthorCollection? = null,
    val category: CategoryCollection? = null
)
