package com.soma.bookstore.products.application.use_case.product.update

import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.domain.repository.ProductRepository
import com.soma.bookstore.products.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class ProductUpdateUseCase(
    private val repository: ProductRepository
) {

    fun update(product: Product, id: String): Product {
        if (repository.existsById(id)) {
            return repository.update(
                Product(
                    id = id,
                    title = product.title,
                    description = product.description,
                    language = product.language,
                    idNumber = product.idNumber,
                    publicationDate = product.publicationDate,
                    author = product.author,
                    category = product.category
                )
            )
        }
        throw NotFoundException("Product with id $id not found, cannot update")
    }
}