package com.soma.bookstore.products.infrastructure.handler.category.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Category
import com.soma.bookstore.products.infrastructure.handler.category.request.CategoryCreateRequest
import com.soma.bookstore.products.infrastructure.handler.category.response.CategoryResponse
import org.springframework.stereotype.Component

@Component
class CategoryResponseMapper: Mapper<CategoryResponse, Category> {

    override fun map(input: Category): CategoryResponse {
        return CategoryResponse(
            id = input.id!!,
            name = input.name
        )
    }
}