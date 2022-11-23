package com.soma.bookstore.products.infrastructure.handler.product.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.soma.bookstore.products.domain.model.Author
import com.soma.bookstore.products.domain.model.Category
import io.swagger.v3.oas.annotations.media.Schema
import java.util.*
import javax.validation.constraints.NotNull

data class ProductCreateRequest(
    @field:Schema(required = true, description = "Title of the product")
    @NotNull(message = "Required")
    @JsonProperty("title")
    val title: String,
    @field:Schema(required = true, description = "Description of the product")
    @NotNull(message = "Required")
    @JsonProperty("description")
    val description: String,
    @field:Schema(required = true, description = "Language what the product is written")
    @NotNull(message = "Required")
    @JsonProperty("language")
    val language: String,
    @field:Schema(required = true, description = "Identification code of the product")
    @NotNull(message = "Required")
    @JsonProperty("id_number")
    val idNumber: String,
    @field:Schema(required = true, description = "Date of publication")
    @NotNull(message = "Required")
    @JsonProperty("publication_date")
    val publicationDate: Date,
    @field:Schema(required = true, description = "Author")
    @NotNull(message = "Required")
    @JsonProperty("author")
    val author: Author,
    @field:Schema(required = true, description = "Category")
    @NotNull(message = "Required")
    @JsonProperty("category")
    val category: Category
)