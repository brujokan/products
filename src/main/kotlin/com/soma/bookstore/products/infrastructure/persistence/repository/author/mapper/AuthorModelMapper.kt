package com.soma.bookstore.products.infrastructure.persistence.repository.author.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Author
import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.infrastructure.persistence.collection.AuthorCollection
import com.soma.bookstore.products.infrastructure.persistence.collection.ProductCollection
import org.springframework.stereotype.Component

@Component
class AuthorModelMapper(
    private val productMapper: Mapper<Product, ProductCollection>
): Mapper<Author, AuthorCollection> {

    override fun map(input: AuthorCollection): Author {
        return Author(
            id = input.id,
            name = input.name,
            description = input.description,
            products = input.products!!.map(productMapper::map)
        )
    }
}