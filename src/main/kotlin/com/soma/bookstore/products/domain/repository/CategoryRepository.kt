package com.soma.bookstore.products.domain.repository

import com.soma.bookstore.products.domain.model.Category

interface CategoryRepository {

    fun save(category: Category): Category

    fun findById(id: String): Category?

    fun findByName(name: String): List<Category>

    fun delete(id: String)

    fun findAll(): List<Category>
    fun existsById(id: String): Boolean

    fun update(category: Category): Category
}