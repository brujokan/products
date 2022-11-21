package com.soma.bookstore.products.infrastructure.persistence.repository.category.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Category
import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.infrastructure.persistence.collection.CategoryCollection
import com.soma.bookstore.products.infrastructure.persistence.collection.ProductCollection
import org.springframework.stereotype.Component

@Component
class CategoryModelMapper(
    private val productMapper: Mapper<Product, ProductCollection>
): Mapper<Category, CategoryCollection> {

    override fun map(input: CategoryCollection): Category {
        return Category(
            id = input.id,
            name = input.name,
            products = input.products!!.map(productMapper::map)
        )
    }
}