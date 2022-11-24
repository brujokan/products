package com.soma.bookstore.products.infrastructure.handler.product.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Author
import com.soma.bookstore.products.domain.model.Category
import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.infrastructure.handler.author.response.AuthorResponse
import com.soma.bookstore.products.infrastructure.handler.category.response.CategoryResponse
import com.soma.bookstore.products.infrastructure.handler.product.response.ProductResponse
import org.springframework.stereotype.Component

@Component
class ProductResponseMapper(
    private val authorMapper: Mapper<AuthorResponse, Author>,
    private val categoryMapper: Mapper<CategoryResponse, Category>
): Mapper<ProductResponse, Product> {

    override fun map(input: Product): ProductResponse {
        return ProductResponse(
            id = input.id!!,
            title = input.title,
            description = input.description,
            language = input.language,
            idNumber = input.idNumber,
            publicationDate = input.publicationDate,
            author = authorMapper.map(input.author!!),
            category = categoryMapper.map(input.category!!)
        )
    }
}