package com.soma.bookstore.products.infrastructure.messaging.producer

import com.fasterxml.jackson.databind.ObjectMapper
import com.soma.bookstore.products.domain.mapper.Mapper
import com.soma.bookstore.products.domain.messaging.ProductIdProducer
import com.soma.bookstore.products.infrastructure.messaging.model.ProductIdMessage
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class ProductIdProducerImpl(
    private val kafkaTemplate: KafkaTemplate<String, Any>,
    @Value("\${kafka.topic.delete}")
    private val topic: String,
    private val messageMapper: Mapper<ProductIdMessage, String>,
    private val objectMapper: ObjectMapper
): ProductIdProducer {

    override fun produce(id: String) {
        val message: String = objectMapper.writeValueAsString(
            messageMapper.map(id)
        )
        kafkaTemplate.send(topic, message)
    }
}