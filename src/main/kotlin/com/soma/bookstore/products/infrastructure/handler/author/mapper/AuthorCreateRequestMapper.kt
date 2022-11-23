package com.soma.bookstore.products.infrastructure.handler.author.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Author
import com.soma.bookstore.products.infrastructure.handler.author.request.AuthorCreateRequest
import org.springframework.stereotype.Component

@Component
class AuthorCreateRequestMapper: Mapper<Author, AuthorCreateRequest> {

    override fun map(input: AuthorCreateRequest): Author {
        return Author(
            name = input.name,
            description = input.description
        )
    }
}