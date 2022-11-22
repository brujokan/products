package com.soma.bookstore.products.application.use_case.author.delete

import com.soma.bookstore.products.domain.repository.AuthorRepository
import com.soma.bookstore.products.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class AuthorDeleteUseCase(
    private val repository: AuthorRepository
) {

    fun delete(id: String) {
        if (repository.existsById(id)) {
            repository.delete(id)
        } else throw NotFoundException("Author with id $id not found, cannot delete")
    }
}