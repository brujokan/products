package com.soma.bookstore.products.application.use_case.category.find_all

import com.soma.bookstore.products.domain.model.Category
import com.soma.bookstore.products.domain.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryFindAllUseCase(
    private val repository: CategoryRepository
) {

    fun findAll(): List<Category> {
        return repository.findAll()
    }
}