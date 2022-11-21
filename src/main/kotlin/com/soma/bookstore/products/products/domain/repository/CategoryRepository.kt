package com.soma.bookstore.products.products.domain.repository

import com.soma.bookstore.products.products.domain.model.Category

interface CategoryRepository {

    fun save(category: Category): Category

    fun findById(id: String): Category?

    fun findByName(name: String): List<Category>

    fun delete(id: String)

    fun findAll(): List<Category>
}