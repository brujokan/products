package com.soma.bookstore.products.application.use_case.author.update

import com.soma.bookstore.products.domain.model.Author
import com.soma.bookstore.products.domain.repository.AuthorRepository
import com.soma.bookstore.products.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class AuthorUpdateUseCase(
    private val repository: AuthorRepository
) {

    fun update(author: Author): Author {
        if (repository.existsById(author.id!!)) {
            return repository.save(
                Author(
                    id = author.id,
                    name = author.name,
                    description = author.description
                )
            )
        }
        throw NotFoundException("Author with id ${author.id} not found, cannot update")
    }
}