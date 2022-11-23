package com.soma.bookstore.products.infrastructure.handler.author.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Author
import com.soma.bookstore.products.infrastructure.handler.author.request.AuthorUpdateRequest
import org.springframework.stereotype.Component

@Component
class AuthorUpdateRequestMapper: Mapper<Author, AuthorUpdateRequest> {

    override fun map(input: AuthorUpdateRequest): Author {
        return Author(
            name = input.name,
            description = input.description
        )
    }
}