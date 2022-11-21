package com.soma.bookstore.products.products.infrastructure.persistence.repository.category

import com.soma.bookstore.products.products.domain.mapper.Mapper
import com.soma.bookstore.products.products.domain.model.Category
import com.soma.bookstore.products.products.domain.repository.CategoryRepository
import com.soma.bookstore.products.products.infrastructure.persistence.collection.CategoryCollection
import com.soma.bookstore.products.products.infrastructure.persistence.mongo.CategoryMongoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class CategoryRepositoryImpl(
    private val repository: CategoryMongoRepository,
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
}