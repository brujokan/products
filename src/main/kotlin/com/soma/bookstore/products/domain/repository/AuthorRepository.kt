package com.soma.bookstore.products.domain.repository

import com.soma.bookstore.products.domain.model.Author

interface AuthorRepository {

    fun save(author: Author): Author

    fun findById(id: String): Author?

    fun findByName(name: String): List<Author>

    fun delete(id: String)

    fun findAll(): List<Author>
}