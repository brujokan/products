package com.soma.bookstore.products.infrastructure.persistence.repository.product.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Author
import com.soma.bookstore.products.domain.model.Category
import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.infrastructure.persistence.collection.AuthorCollection
import com.soma.bookstore.products.infrastructure.persistence.collection.CategoryCollection
import com.soma.bookstore.products.infrastructure.persistence.collection.ProductCollection
import org.springframework.stereotype.Component

@Component
class ProductCollectionMapper(
    private val authorMapper: Mapper<AuthorCollection, Author>,
    private val categoryMapper: Mapper<CategoryCollection, Category>
): Mapper<ProductCollection, Product> {

    override fun map(input: Product): ProductCollection {
        return ProductCollection(
            id = input.id,
            title = input.title,
            description = input.description,
            language = input.language,
            idNumber = input.idNumber,
            publicationDate = input.publicationDate,
            author = authorMapper.map(input.author!!),
            category = categoryMapper.map(input.category!!)
        )
    }
}