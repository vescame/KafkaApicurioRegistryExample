package com.picpay.apicurio.spike.user.config

import io.apicurio.registry.serde.SerdeConfig
import io.apicurio.registry.serde.avro.AvroKafkaSerializer
import java.util.Properties
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class KafkaProperties {
    val topicName = "user-creation"
    val topicPartition = 0
    val kafkaClusterUrl = "http://localhost:9092"
    val schemaRegistryUrl = "http://localhost:8080/apis/registry/v2"
    @Bean(name = ["producerProperties"])
    fun producerProperties() : Properties {
        return Properties().apply {
            put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaClusterUrl)
            put(ProducerConfig.CLIENT_ID_CONFIG, "producer-$topicName")
            put(ProducerConfig.ACKS_CONFIG, "all")
            put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java.name)
            put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, AvroKafkaSerializer::class.java.name)
//            FindLatestVersionStragety
            put(SerdeConfig.REGISTRY_URL, schemaRegistryUrl)
            // verificar como padronizar o nome sem ter que explicitar o group e id to artefato
            put(SerdeConfig.EXPLICIT_ARTIFACT_GROUP_ID, "com.picpay.apicurio.spike.user")
            put(SerdeConfig.EXPLICIT_ARTIFACT_ID, "User")
            put(SerdeConfig.AUTO_REGISTER_ARTIFACT, "false")
        }
    }
}