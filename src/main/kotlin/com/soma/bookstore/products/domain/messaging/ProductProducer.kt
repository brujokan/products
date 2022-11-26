package com.soma.bookstore.products.domain.messaging

import com.soma.bookstore.products.domain.model.Product

interface ProductProducer {

    fun send(product: Product)
}