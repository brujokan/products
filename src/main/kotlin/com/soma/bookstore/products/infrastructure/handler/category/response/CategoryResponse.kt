package com.soma.bookstore.products.infrastructure.handler.category.response

import com.fasterxml.jackson.annotation.JsonProperty

data class CategoryResponse(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("name")
    val name: String
)
