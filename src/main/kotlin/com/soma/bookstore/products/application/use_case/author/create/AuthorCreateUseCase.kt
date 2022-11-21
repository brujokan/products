package com.soma.bookstore.products.application.use_case.author.create

import com.soma.bookstore.products.domain.model.Author
import com.soma.bookstore.products.domain.repository.AuthorRepository
import org.springframework.stereotype.Service

@Service
class AuthorCreateUseCase(
    private val authorRepository: AuthorRepository
) {

    fun create(author: Author): Author {
        return authorRepository.save(author)
    }
}