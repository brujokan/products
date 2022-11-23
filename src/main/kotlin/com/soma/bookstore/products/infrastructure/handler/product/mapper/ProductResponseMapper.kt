package com.soma.bookstore.products.infrastructure.handler.product.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.infrastructure.handler.product.request.ProductCreateRequest
import com.soma.bookstore.products.infrastructure.handler.product.response.ProductResponse
import org.springframework.stereotype.Component

@Component
class ProductResponseMapper: Mapper<ProductResponse, Product> {

    override fun map(input: Product): ProductResponse {
        return ProductResponse(
            id = input.id!!,
            title = input.title,
            description = input.description,
            language = input.language,
            idNumber = input.description,
            publicationDate = input.publicationDate,
            author = input.author!!,
            category = input.category!!
        )
    }
}