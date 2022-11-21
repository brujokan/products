package com.soma.bookstore.products.products.domain.repository

import com.soma.bookstore.products.products.domain.model.Author
import com.soma.bookstore.products.products.domain.model.Category
import com.soma.bookstore.products.products.domain.model.Product

interface ProductRepository {

    fun save(product: Product): Product

    fun findById(id: String): Product?

    fun findByTitle(name: String): List<Product>

    fun findByAuthor(author: Author): List<Product>

    fun findByCategory(category: Category): List<Product>

    fun delete(id: String)

    fun findAll(): List<Product>
}