package com.soma.bookstore.products.infrastructure.persistence.repository.product

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Author
import com.soma.bookstore.products.domain.model.Category
import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.domain.repository.ProductRepository
import com.soma.bookstore.products.infrastructure.persistence.collection.AuthorCollection
import com.soma.bookstore.products.infrastructure.persistence.collection.CategoryCollection
import com.soma.bookstore.products.infrastructure.persistence.collection.ProductCollection
import com.soma.bookstore.products.infrastructure.persistence.mongo.ProductMongoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class ProductRepositoryImpl(
    private val repository: ProductMongoRepository,
    private val modelMapper: Mapper<Product, ProductCollection>,
    private val collectionMapper: Mapper<ProductCollection, Product>,
    private val authorCollectionMapper: Mapper<AuthorCollection, Author>,
    private val categoryCollectionMapper: Mapper<CategoryCollection, Category>
): ProductRepository {

    override fun save(product: Product): Product {
        return modelMapper.map(
            repository.save(collectionMapper.map(product))
        )
    }

    override fun findById(id: String): Product? {
        return repository.findByIdOrNull(id)?.let { modelMapper.map(it) }
    }

    override fun findByTitle(name: String): List<Product> {
        return repository.findByTitle(name).map(modelMapper::map)
    }

    override fun findByAuthor(author: Author): List<Product> {
        return repository.findByAuthor(
            authorCollectionMapper.map(author)
        ).map(modelMapper::map)
    }

    override fun findByCategory(category: Category): List<Product> {
        return repository.findByCategory(
            categoryCollectionMapper.map(category)
        ).map(modelMapper::map)
    }

    override fun delete(id: String) = repository.deleteById(id)

    override fun findAll(): List<Product> {
        return repository.findAll().map(modelMapper::map)
    }
}