package com.soma.bookstore.products.infrastructure.persistence.mongo

import com.soma.bookstore.products.infrastructure.persistence.collection.CategoryCollection
import org.springframework.data.mongodb.repository.MongoRepository

interface CategoryMongoRepository: MongoRepository<CategoryCollection, String> {

    fun findByName(name: String): List<CategoryCollection>
}