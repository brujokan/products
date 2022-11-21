package com.soma.bookstore.products.products.infrastructure.persistence.mongo

import com.soma.bookstore.products.products.infrastructure.persistence.collection.AuthorCollection
import com.soma.bookstore.products.products.infrastructure.persistence.collection.CategoryCollection
import com.soma.bookstore.products.products.infrastructure.persistence.collection.ProductCollection
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductMongoRepository: MongoRepository<ProductCollection, String> {

    fun findByTitle(title: String): List<ProductCollection>

    fun findByAuthor(author: AuthorCollection): List<ProductCollection>

    fun findByCategory(category: CategoryCollection): List<ProductCollection>
}