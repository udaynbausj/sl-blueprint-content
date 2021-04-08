package io.blueprint.content.services


interface KafkaService {
    fun sendMessage(topic : String, message : Any)
}
