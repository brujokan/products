package com.soma.bookstore.products.application.use_case.product.create

import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.domain.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductCreateUseCase(
    private val repository: ProductRepository
) {
    fun create(product: Product): Product {
        return repository.save(product)
    }
}