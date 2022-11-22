package com.soma.bookstore.products.application.use_case.author.find_all

import com.soma.bookstore.products.domain.model.Author
import com.soma.bookstore.products.domain.repository.AuthorRepository
import org.springframework.stereotype.Service

@Service
class AuthorFindAllUseCase(
    private val repository: AuthorRepository
) {

    fun findAll(): List<Author> {
        return repository.findAll()
    }
}