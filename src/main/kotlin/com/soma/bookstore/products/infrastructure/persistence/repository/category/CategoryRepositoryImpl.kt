package com.soma.bookstore.products.infrastructure.persistence.repository.category

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Category
import com.soma.bookstore.products.domain.repository.CategoryRepository
import com.soma.bookstore.products.infrastructure.persistence.collection.CategoryCollection
import com.soma.bookstore.products.infrastructure.persistence.mongo.CategoryMongoRepository
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class CategoryRepositoryImpl(
    private val repository: CategoryMongoRepository,
    private val mongoTemplate: MongoTemplate,
    private val modelMapper: Mapper<Category, CategoryCollection>,
    private val collectionMapper: Mapper<CategoryCollection, Category>
): CategoryRepository {

    override fun save(category: Category): Category {
        return modelMapper.map(
            repository.save(collectionMapper.map(category))
        )
    }

    override fun findById(id: String): Category? {
        return repository.findByIdOrNull(id)?.let { modelMapper.map(it) }
    }

    override fun findByName(name: String): List<Category> {
        return repository.findByName(name).map(modelMapper::map)
    }

    override fun delete(id: String) = repository.deleteById(id)

    override fun findAll(): List<Category> {
        return repository.findAll().map(modelMapper::map)
    }

    override fun existsById(id: String): Boolean {
        return repository.existsById(id)
    }

    override fun update(category: Category): Category {
        val query = Query()
        query.addCriteria(Criteria.where("id").`is`(category.id))
        val update = Update()
        update.set("name", category.name)

        return modelMapper.map(
            mongoTemplate.findAndModify(query, update, CategoryCollection::class.java)!!
        )
    }
}