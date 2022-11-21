package com.soma.bookstore.products.products.infrastructure.persistence.repository.product.mapper

import com.soma.bookstore.products.products.domain.mapper.Mapper
import com.soma.bookstore.products.products.domain.model.Product
import com.soma.bookstore.products.products.infrastructure.persistence.collection.ProductCollection
import org.springframework.stereotype.Component

@Component
class ProductCollectionMapper: Mapper<ProductCollection, Product> {

    override fun map(input: Product): ProductCollection {
        return ProductCollection(
            id = input.id,
            title = input.title,
            description = input.description,
            language = input.language,
            idNumber = input.idNumber,
            publicationDate = input.publicationDate
        )
    }
}