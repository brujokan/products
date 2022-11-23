package com.soma.bookstore.products.application.use_case.author.update

import com.soma.bookstore.products.domain.model.Author
import com.soma.bookstore.products.domain.repository.AuthorRepository
import com.soma.bookstore.products.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class AuthorUpdateUseCase(
    private val repository: AuthorRepository
) {

    fun update(author: Author, id: String): Author {
        if (repository.existsById(id)) {
            return repository.update(
                Author(
                    id = id,
                    name = author.name,
                    description = author.description
                )
            )
        }
        throw NotFoundException("Author with id $id not found, cannot update")
    }
}