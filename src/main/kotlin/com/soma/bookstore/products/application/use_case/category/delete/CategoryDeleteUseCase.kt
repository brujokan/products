package com.soma.bookstore.products.application.use_case.category.delete

import com.soma.bookstore.products.domain.repository.CategoryRepository
import com.soma.bookstore.products.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class CategoryDeleteUseCase(
    private val repository: CategoryRepository
) {

    fun delete(id: String) {
        if (repository.existsById(id)) {
            repository.delete(id)
        } else throw NotFoundException("Category with id $id not exists, cannot delete")
    }
}