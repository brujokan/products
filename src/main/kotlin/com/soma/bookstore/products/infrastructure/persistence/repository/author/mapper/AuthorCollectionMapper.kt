package com.soma.bookstore.products.infrastructure.persistence.repository.author.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Author
import com.soma.bookstore.products.infrastructure.persistence.collection.AuthorCollection
import org.springframework.stereotype.Component

@Component
class AuthorCollectionMapper(): Mapper<AuthorCollection, Author> {

    override fun map(input: Author): AuthorCollection {
        return AuthorCollection(
            id = input.id,
            name = input.name,
            description = input.description
        )
    }
}