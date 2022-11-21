package com.soma.bookstore.products.products.infrastructure.persistence.repository.author.mapper

import com.soma.bookstore.products.products.domain.mapper.Mapper
import com.soma.bookstore.products.products.domain.model.Author
import com.soma.bookstore.products.products.domain.model.Product
import com.soma.bookstore.products.products.infrastructure.persistence.collection.AuthorCollection
import com.soma.bookstore.products.products.infrastructure.persistence.collection.ProductCollection
import org.springframework.stereotype.Component

@Component
class AuthorCollectionMapper(
    private val productMapper: Mapper<ProductCollection, Product>
): Mapper<AuthorCollection, Author> {

    override fun map(input: Author): AuthorCollection {
        return AuthorCollection(
            id = input.id,
            name = input.name,
            description = input.description,
            products = input.products!!.map(productMapper::map)
        )
    }
}