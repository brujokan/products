package com.soma.bookstore.products.infrastructure.messaging.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.infrastructure.messaging.model.ProductMessage
import org.springframework.stereotype.Component

@Component
class ProductMessageMapper: Mapper<ProductMessage, Product> {

    override fun map(input: Product): ProductMessage {
        return ProductMessage(
            id = input.id!!,
            title = input.title,
            idNumber = input.idNumber,
            language = input.language,
            author = input.author!!.name,
            category = input.category!!.name
        )
    }
}