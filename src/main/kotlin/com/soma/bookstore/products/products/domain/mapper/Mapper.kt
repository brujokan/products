package com.soma.bookstore.products.products.domain.mapper

interface Mapper<T, V> {

    fun map(input: V): T
}