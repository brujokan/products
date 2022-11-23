package com.soma.bookstore.products.infrastructure.handler.category.request

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotNull

data class CategoryUpdateRequest(
    @field:Schema(required = true, description = "Name of the category")
    @NotNull(message = "Required")
    @JsonProperty("name")
    val name: String
)
