package com.soma.bookstore.products.infrastructure.handler.category.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Category
import com.soma.bookstore.products.infrastructure.handler.category.request.CategoryCreateRequest
import org.springframework.stereotype.Component

@Component
class CategoryCreateRequestMapper: Mapper<Category, CategoryCreateRequest> {

    override fun map(input: CategoryCreateRequest): Category {
        return Category(
            name = input.name
        )
    }
}