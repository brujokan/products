package com.soma.bookstore.products.infrastructure.messaging.producer

import com.fasterxml.jackson.databind.ObjectMapper
import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.messaging.ProductProducer
import com.soma.bookstore.products.domain.model.Product
import com.soma.bookstore.products.infrastructure.messaging.model.ProductMessage
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class ProductProducerImpl(
    private val kafkaTemplate: KafkaTemplate<String, Any>,
    @Value("\${kafka.topic.create}")
    private val topic: String,
    private val messageMapper: Mapper<ProductMessage, Product>,
    private val objectMapper: ObjectMapper
): ProductProducer {

    private val logger = KotlinLogging.logger {  }

    override fun send(product: Product) {
        val message: String = objectMapper.writeValueAsString(
            messageMapper.map(product)
        )
        kafkaTemplate.send(topic, message)
        logger.info { message }
    }
}