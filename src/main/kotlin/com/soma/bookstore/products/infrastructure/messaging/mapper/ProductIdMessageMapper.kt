package com.soma.bookstore.products.infrastructure.messaging.mapper

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.infrastructure.messaging.model.ProductIdMessage
import org.springframework.stereotype.Component

@Component
class ProductIdMessageMapper: Mapper<ProductIdMessage, String> {

    override fun map(input: String): ProductIdMessage {
        return ProductIdMessage(
            id = input
        )
    }
}