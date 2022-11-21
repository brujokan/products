package com.soma.bookstore.products.products.infrastructure.persistence.mongo

import com.soma.bookstore.products.products.infrastructure.persistence.collection.AuthorCollection
import org.springframework.data.mongodb.repository.MongoRepository

interface AuthorMongoRepository: MongoRepository<AuthorCollection, String> {

    fun findByName(name: String): List<AuthorCollection>
}