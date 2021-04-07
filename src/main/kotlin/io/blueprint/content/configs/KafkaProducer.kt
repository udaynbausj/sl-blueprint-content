package io.blueprint.content.configs

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
class KafkaProducer constructor(@Autowired val envProperties: EnvProperties) {

    fun producerConfig() : Map<String, Any> {
        val options = mutableMapOf<String,Any>()
        options[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = envProperties.kafkaBootStrapServers
        options[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class
        options[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class
        return options
    }

}