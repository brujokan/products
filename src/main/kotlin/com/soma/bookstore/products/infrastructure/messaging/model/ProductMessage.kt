package com.soma.bookstore.products.infrastructure.messaging.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ProductMessage(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("language")
    val language: String,
    @JsonProperty("id_number")
    val idNumber: String,
    @JsonProperty("author")
    val author: String,
    @JsonProperty("category")
    val category: String
)
