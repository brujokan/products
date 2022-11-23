package com.soma.bookstore.products.infrastructure.handler.category.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Category
import com.soma.bookstore.products.infrastructure.handler.category.request.CategoryCreateRequest
import com.soma.bookstore.products.infrastructure.handler.category.request.CategoryUpdateRequest
import org.springframework.stereotype.Component

@Component
class CategoryUpdateRequestMapper: Mapper<Category, CategoryUpdateRequest> {

    override fun map(input: CategoryUpdateRequest): Category {
        return Category(
            name = input.name
        )
    }
}