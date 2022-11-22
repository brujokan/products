package com.soma.bookstore.products.application.use_case.category.update

import com.soma.bookstore.products.domain.model.Category
import com.soma.bookstore.products.domain.repository.CategoryRepository
import com.soma.bookstore.products.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class CategoryUpdateUseCase(
    private val repository: CategoryRepository
) {

    fun update(category: Category): Category {
        if (repository.existsById(category.id!!)) {
            return repository.update(category)
        } else throw NotFoundException("Category with id ${category.id} not found, cannot update")
    }
}