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
class ProductModelMapper(
    private val authorMapper: Mapper<Author, AuthorCollection>,
    private val categoryMapper: Mapper<Category, CategoryCollection>
): Mapper<Product, ProductCollection> {

    override fun map(input: ProductCollection): Product {
        return Product(
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