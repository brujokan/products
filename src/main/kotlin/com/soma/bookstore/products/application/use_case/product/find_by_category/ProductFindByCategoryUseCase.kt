package com.soma.bookstore.products.application.use_case.product.find_by_category

import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.domain.repository.CategoryRepository
import com.soma.bookstore.products.domain.repository.ProductRepository
import com.soma.bookstore.products.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class ProductFindByCategoryUseCase(
    private val repository: ProductRepository,
    private val categoryRepository: CategoryRepository
) {

    fun findByCategory(category_id: String): List<Product> {
        val category = categoryRepository.findById(category_id) ?: throw NotFoundException("Category with id $category_id not found")
        return repository.findByCategory(category)
    }
}