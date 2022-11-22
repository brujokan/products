package com.soma.bookstore.products.application.use_case.product.find_by_category

import com.soma.bookstore.products.domain.model.Category
import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.domain.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductFindByCategoryUseCase(
    private val repository: ProductRepository
) {

    fun findByCategory(category: Category): List<Product> {
        return repository.findByCategory(category)
    }
}