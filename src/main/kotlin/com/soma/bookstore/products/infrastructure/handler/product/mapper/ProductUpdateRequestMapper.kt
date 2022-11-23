package com.soma.bookstore.products.infrastructure.handler.product.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.infrastructure.handler.product.request.ProductUpdateRequest
import org.springframework.stereotype.Component

@Component
class ProductUpdateRequestMapper: Mapper<Product, ProductUpdateRequest> {

    override fun map(input: ProductUpdateRequest): Product {
        return Product(
            title = input.title,
            description = input.description,
            language = input.language,
            idNumber = input.description,
            publicationDate = input.publicationDate,
            author = input.author,
            category = input.category
        )
    }
}