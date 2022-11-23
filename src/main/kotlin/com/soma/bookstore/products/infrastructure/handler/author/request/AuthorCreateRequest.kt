package com.soma.bookstore.products.infrastructure.handler.author.request

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotNull

data class AuthorCreateRequest(
    @field:Schema(required = true, description = "Name of the author")
    @NotNull(message = "Required")
    @JsonProperty("name")
    val name: String,
    @field:Schema(required = true, description = "Description of the author")
    @NotNull(message = "Required")
    @JsonProperty("description")
    val description: String
)
