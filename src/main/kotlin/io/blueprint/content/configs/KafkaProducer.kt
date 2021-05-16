package io.blueprint.content.configs

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class KafkaProducerConfig constructor(@Autowired val envProperties: EnvProperties) {

    @Bean
    fun producerFactory() : ProducerFactory<String,Any> {

        val options = mutableMapOf<String,Any>()
        options[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = envProperties.kafkaBootStrapServers
        options[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.canonicalName
        options[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.canonicalName

        return DefaultKafkaProducerFactory(options)
    }


    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    fun kafkaTemplate() : KafkaTemplate<String,Any> {
        return KafkaTemplate(producerFactory())
    }

}
