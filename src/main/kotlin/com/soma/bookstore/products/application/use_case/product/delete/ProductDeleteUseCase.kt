package com.soma.bookstore.products.application.use_case.product.delete

import com.soma.bookstore.products.domain.repository.ProductRepository
import com.soma.bookstore.products.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class ProductDeleteUseCase(
    private val repository: ProductRepository
) {
    fun delete(id: String) {
        if (repository.existsById(id)) {
            repository.delete(id)
        } else throw NotFoundException("Product with id $id not found, cannot delete")
    }
}