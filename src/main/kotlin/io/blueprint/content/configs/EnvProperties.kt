package io.blueprint.content.configs

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class EnvProperties {

    @Value(value = "spring.kafka.bootstrap-servers")
    val kafkaBootStrapServers : String = ""

    @Value(value = "spring.kafka.consumer.group-id")
    val kafkaConsumerGroupId : String = ""

}