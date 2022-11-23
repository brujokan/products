package com.soma.bookstore.products.infrastructure.handler.author.response

import com.fasterxml.jackson.annotation.JsonProperty

data class AuthorResponse(
    val id: String,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("description")
    val description: String
)
