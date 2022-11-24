package com.soma.bookstore.products.application.use_case.product.find_by_author

import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.domain.repository.AuthorRepository
import com.soma.bookstore.products.domain.repository.ProductRepository
import com.soma.bookstore.products.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class ProductFindByAuthorUseCase(
    private val repository: ProductRepository,
    private val authorRepository: AuthorRepository
) {

    fun findByAuthor(author_id: String): List<Product> {
        val author = authorRepository.findById(author_id) ?: throw NotFoundException("Author with id $author_id not found")
        return repository.findByAuthor(author)
    }
}