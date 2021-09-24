package com.picpay.apicurio.spike.user.repository

import com.picpay.apicurio.spike.user.config.KafkaProperties
import com.picpay.apicurio.spike.user.dto.User
import java.util.UUID
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.stereotype.Service
import com.picpay.apicurio.spike.user.avro.User as AvroUser

@Service
class KafkaProducer(private val kafkaProps: KafkaProperties) {
    private val producerProperties = kafkaProps.producerProperties()
    fun produce(user: User) {
        val topicUser = AvroUser(user.name, user.age)
        val producer = KafkaProducer<String, AvroUser>(producerProperties)
        val record = ProducerRecord(
            kafkaProps.topicName,
            UUID.randomUUID().toString(),
            topicUser
        )
        val callback = producer.send(record)
        println(callback.get())
        producer.flush()
        producer.close()
    }
}