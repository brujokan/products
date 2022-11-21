package com.soma.bookstore.products.infrastructure.persistence.repository.product.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.infrastructure.persistence.collection.ProductCollection
import org.springframework.stereotype.Component

@Component
class ProductModelMapper: Mapper<Product, ProductCollection> {

    override fun map(input: ProductCollection): Product {
        return Product(
            id = input.id,
            title = input.title,
            description = input.description,
            language = input.language,
            idNumber = input.idNumber,
            publicationDate = input.publicationDate
        )
    }
}