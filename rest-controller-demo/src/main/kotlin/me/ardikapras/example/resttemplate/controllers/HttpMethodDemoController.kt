package me.ardikapras.example.resttemplate.controllers

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/http-methods")
class HttpMethodController {

    @GetMapping("/demo")
    fun getDemoEndpoint() = "This is GET method"

    @PostMapping("/demo")
    fun postDemoEndpoint() = "This is POST method"

    @PutMapping("/demo")
    fun putDemoEndpoint() = "This is PUT method"

    @DeleteMapping("/demo")
    fun deleteDemoEndpoint() = "This is DELETE method"

    @PatchMapping("/demo")
    fun patchDemoEndpoint() = "This is PATCH method"
}
