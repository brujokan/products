package com.soma.bookstore.products.application.use_case.product.update

import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.domain.repository.ProductRepository
import com.soma.bookstore.products.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class ProductUpdateUseCase(
    private val repository: ProductRepository
) {

    fun update(product: Product): Product {
        if (repository.existsById(product.id!!)) {
            return repository.update(product)
        }
        throw NotFoundException("Product with id ${product.id} not found, cannot update")
    }
}