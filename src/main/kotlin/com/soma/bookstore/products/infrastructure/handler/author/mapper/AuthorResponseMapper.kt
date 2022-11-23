package com.soma.bookstore.products.infrastructure.handler.author.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Author
import com.soma.bookstore.products.infrastructure.handler.author.response.AuthorResponse
import org.springframework.stereotype.Component

@Component
class AuthorResponseMapper: Mapper<AuthorResponse, Author> {

    override fun map(input: Author): AuthorResponse {
        return AuthorResponse(
            id = input.id!!,
            name = input.name,
            description = input.description
        )
    }
}