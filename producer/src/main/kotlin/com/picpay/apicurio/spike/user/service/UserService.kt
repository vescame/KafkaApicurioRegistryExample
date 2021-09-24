package com.picpay.apicurio.spike.user.service

import com.picpay.apicurio.spike.user.dto.User
import com.picpay.apicurio.spike.user.repository.KafkaProducer
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: KafkaProducer) {
    fun create(user: User) {
        repository.produce(user)
    }
}