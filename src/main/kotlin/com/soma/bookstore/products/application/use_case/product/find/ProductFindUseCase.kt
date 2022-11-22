package com.soma.bookstore.products.application.use_case.product.find

import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.domain.repository.ProductRepository
import com.soma.bookstore.products.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class ProductFindUseCase(
    private val repository: ProductRepository
) {
    fun find(id: String): Product {
        return repository.findById(id) ?: throw NotFoundException("Product with id $id not found")
    }
}