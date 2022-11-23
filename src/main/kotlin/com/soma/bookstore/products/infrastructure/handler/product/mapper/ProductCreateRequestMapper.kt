package com.soma.bookstore.products.infrastructure.handler.product.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.infrastructure.handler.product.request.ProductCreateRequest
import org.springframework.stereotype.Component

@Component
class ProductCreateRequestMapper: Mapper<Product, ProductCreateRequest> {

    override fun map(input: ProductCreateRequest): Product {
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