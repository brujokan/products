package com.soma.bookstore.products.infrastructure.handler.product.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.soma.bookstore.products.domain.model.Author
import com.soma.bookstore.products.domain.model.Category
import io.swagger.v3.oas.annotations.media.Schema
import java.util.*
import javax.validation.constraints.NotNull

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
    val author: Author,
    @JsonProperty("category")
    val category: Category
)