package com.soma.bookstore.products.products.infrastructure.persistence.repository.author

import com.soma.bookstore.products.products.domain.mapper.Mapper
import com.soma.bookstore.products.products.domain.model.Author
import com.soma.bookstore.products.products.domain.repository.AuthorRepository
import com.soma.bookstore.products.products.infrastructure.persistence.collection.AuthorCollection
import com.soma.bookstore.products.products.infrastructure.persistence.mongo.AuthorMongoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class AuthorRepositoryImpl(
    private val mongoRepository: AuthorMongoRepository,
    private val modelMapper: Mapper<Author, AuthorCollection>,
    private val collectionMapper: Mapper<AuthorCollection, Author>
): AuthorRepository {

    override fun save(author: Author): Author {
        return modelMapper.map(
            mongoRepository.save(
                collectionMapper.map(author)
            )
        )
    }

    override fun findById(id: String): Author? {
        return mongoRepository.findByIdOrNull(id)?.let { modelMapper.map(it) }
    }

    override fun findByName(name: String): List<Author> {
        return mongoRepository.findByName(name).map(modelMapper::map)
    }

    override fun delete(id: String) = mongoRepository.deleteById(id)

    override fun findAll(): List<Author> {
        return mongoRepository.findAll().map(modelMapper::map)
    }
}