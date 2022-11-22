package com.soma.bookstore.products.application.use_case.product.find_by_author

import com.soma.bookstore.products.domain.model.Author
import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.domain.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductFindByAuthorUseCase(
    private val repository: ProductRepository
) {

    fun findByAuthor(author: Author): List<Product> {
        return repository.findByAuthor(author)
    }
}