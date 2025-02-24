package me.ardikapras.example.resttemplate.controllers

import me.ardikapras.example.resttemplate.models.ComplexRequest
import me.ardikapras.example.resttemplate.models.Message
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/body-demo")
class RequestBodyDemoController {

    @PostMapping("/string")
    fun stringBody(@RequestBody content: String) = "Received string body: $content"

    @PostMapping("/message")
    fun messageBody(@RequestBody message: Message) = "Received message with content: ${message.content}"

    @PostMapping("/complex")
    fun complexBody(@RequestBody request: ComplexRequest) =
        "Received complex request - id: ${request.id}, productId: ${request.productId}, name: ${request.name}, items: ${request.items.joinToString()}"
}
