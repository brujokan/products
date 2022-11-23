package com.soma.bookstore.products.infrastructure.persistence.repository.category.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Category
import com.soma.bookstore.products.infrastructure.persistence.collection.CategoryCollection
import org.springframework.stereotype.Component

@Component
class CategoryCollectionMapper() : Mapper<CategoryCollection, Category> {

    override fun map(input: Category): CategoryCollection {
        return CategoryCollection(
            id = input.id,
            name = input.name
        )
    }
}