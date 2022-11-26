package com.soma.bookstore.products.application.use_case.product.create

import com.soma.bookstore.products.domain.messaging.ProductProducer
import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.domain.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductCreateUseCase(
    private val repository: ProductRepository,
    private val producer: ProductProducer
) {
    fun create(product: Product): Product {
        val savedProduct = repository.save(product)
        producer.send(savedProduct)

        return savedProduct
    }
}