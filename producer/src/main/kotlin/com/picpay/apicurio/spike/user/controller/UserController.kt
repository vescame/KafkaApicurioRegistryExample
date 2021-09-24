package com.picpay.apicurio.spike.user.controller

import com.picpay.apicurio.spike.user.dto.User
import com.picpay.apicurio.spike.user.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/user")
class UserController(private val service: UserService) {
    @PostMapping
    fun create(@RequestBody user: User) {
        service.create(user)
    }
}