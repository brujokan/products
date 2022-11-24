package com.soma.bookstore.products.infrastructure.handler.product.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.soma.bookstore.products.infrastructure.handler.author.response.AuthorResponse
import com.soma.bookstore.products.infrastructure.handler.category.response.CategoryResponse
import java.util.*

data class ProductResponse(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("description")
    val description: String,
    @JsonProperty("language")
    val language: String,
    @JsonProperty("id_number")
    val idNumber: String,
    @JsonProperty("publication_date")
    val publicationDate: Date,
    @JsonProperty("author")
    val author: AuthorResponse,
    @JsonProperty("category")
    val category: CategoryResponse
)