package com.soma.bookstore.products.infrastructure.persistence.repository.author

import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.model.Author
import com.soma.bookstore.products.domain.repository.AuthorRepository
import com.soma.bookstore.products.infrastructure.persistence.collection.AuthorCollection
import com.soma.bookstore.products.infrastructure.persistence.mongo.AuthorMongoRepository
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class AuthorRepositoryImpl(
    private val mongoRepository: AuthorMongoRepository,
    private val mongoTemplate: MongoTemplate,
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

    override fun existsById(id: String): Boolean {
        return mongoRepository.existsById(id)
    }

    override fun update(author: Author): Author {
        val query = Query()
        query.addCriteria(Criteria.where("id").`is`(author.id))
        val update = Update()
        update.set("name", author.name)
        update.set("description", author.description)

        return modelMapper.map(
            mongoTemplate.findAndModify(query, update, AuthorCollection::class.java)!!
        )
    }
}