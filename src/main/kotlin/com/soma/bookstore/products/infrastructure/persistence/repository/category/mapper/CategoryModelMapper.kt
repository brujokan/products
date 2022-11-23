package com.soma.bookstore.products.infrastructure.persistence.repository.category.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Category
import com.soma.bookstore.products.infrastructure.persistence.collection.CategoryCollection
import org.springframework.stereotype.Component

@Component
class CategoryModelMapper() : Mapper<Category, CategoryCollection> {

    override fun map(input: CategoryCollection): Category {
        return Category(
            id = input.id,
            name = input.name
        )
    }
}