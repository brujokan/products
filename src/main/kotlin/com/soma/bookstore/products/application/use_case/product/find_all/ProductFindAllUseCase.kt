package com.soma.bookstore.products.application.use_case.product.find_all

import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.domain.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductFindAllUseCase(
    private val repository: ProductRepository
) {
    fun findAll(): List<Product> {
        return repository.findAll()
    }
}