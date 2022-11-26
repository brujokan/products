package com.soma.bookstore.products.application.use_case.product.delete

import com.soma.bookstore.products.domain.messaging.ProductIdProducer
import com.soma.bookstore.products.domain.repository.ProductRepository
import com.soma.bookstore.products.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class ProductDeleteUseCase(
    private val repository: ProductRepository,
    private val producer: ProductIdProducer
) {
    fun delete(id: String) {
        if (repository.existsById(id)) {
            repository.delete(id)

            producer.produce(id)
        } else throw NotFoundException("Product with id $id not found, cannot delete")
    }
}