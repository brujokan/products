package com.soma.bookstore.products.domain.messaging

interface ProductIdProducer {

    fun produce(id: String)
}