package com.soma.bookstore.products.application.use_case.category.find

import com.soma.bookstore.products.domain.model.Category
import com.soma.bookstore.products.domain.repository.CategoryRepository
import com.soma.bookstore.products.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class CategoryFindUseCase(
    private val repository: CategoryRepository
) {

    fun find(id: String): Category {
        return repository.findById(id) ?: throw NotFoundException("Category with id $id not found")
    }
}