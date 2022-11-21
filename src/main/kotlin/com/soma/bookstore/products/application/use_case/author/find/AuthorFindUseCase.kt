package com.soma.bookstore.products.application.use_case.author.find

import com.soma.bookstore.products.domain.model.Author
import com.soma.bookstore.products.domain.repository.AuthorRepository
import com.soma.bookstore.products.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class AuthorFindUseCase(
    private val repository: AuthorRepository
) {

    fun find(id: String): Author {
        return repository.findById(id) ?: throw NotFoundException("Author with id ${id} not found")
    }
}