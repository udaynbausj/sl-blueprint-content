package io.blueprint.content.configs

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class EnvProperties(@Value("\${spring.kafka.bootstrap-servers}") var kafkaBootStrapServers : String) {

}