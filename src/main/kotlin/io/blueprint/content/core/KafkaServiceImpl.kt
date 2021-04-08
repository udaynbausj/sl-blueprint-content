package io.blueprint.content.core

import io.blueprint.content.configs.KafkaProducerConfig
import io.blueprint.content.services.KafkaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class KafkaServiceImpl constructor(@Autowired val kafkaProducerConfig: KafkaProducerConfig): KafkaService {

    override fun sendMessage(topic: String, message: Any) {
        kafkaProducerConfig.kafkaTemplate().send(topic,message)
    }
}