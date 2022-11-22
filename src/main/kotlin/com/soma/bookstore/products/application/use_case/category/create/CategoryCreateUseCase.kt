package com.soma.bookstore.products.application.use_case.category.create

import com.soma.bookstore.products.domain.model.Category
import com.soma.bookstore.products.domain.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryCreateUseCase(
    private val repository: CategoryRepository
) {

    fun create(category: Category): Category {
        return repository.save(category)
    }
}