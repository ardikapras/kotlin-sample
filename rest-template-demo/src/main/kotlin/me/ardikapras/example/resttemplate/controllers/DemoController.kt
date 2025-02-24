package me.ardikapras.example.resttemplate.controllers

import me.ardikapras.example.resttemplate.basic.BasicRestTemplateDemo
import me.ardikapras.example.resttemplate.converter.MessageConverterDemo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.File

@RestController
@RequestMapping("/api/demo")
class DemoController(
    private val basicDemo: BasicRestTemplateDemo,
    private val converterDemo: MessageConverterDemo
) {
    @GetMapping("/simple")
    fun getSimpleString(): String? {
        return basicDemo.getSimpleString()
    }

    @GetMapping("/with-response-entity")
    fun getWithResponseEntity(): ResponseEntity<String> {
        return basicDemo.getWithResponseEntity()
    }

    @PostMapping("/post")
    fun postString(@RequestBody message: String): String? {
        return basicDemo.postString(message)
    }

    @GetMapping("/with-error")
    fun getWithErrorHandling(): Result<String> {
        return basicDemo.getWithErrorHandling()
    }

    // ALL endpoints for MessageConverterDemo
    @PostMapping("/converters/json")
    fun sendJsonRequest(@RequestBody data: Any): Any? {
        return converterDemo.sendJsonRequest("https://api.example.com/json", data)
    }

    @PostMapping("/converters/form")
    fun sendFormData(@RequestBody formData: Map<String, String>): String? {
        return converterDemo.sendFormData("https://api.example.com/form", formData)
    }

    @PostMapping("/converters/multipart")
    fun uploadFile(
        @RequestParam("file") file: File,
        @RequestParam additionalData: Map<String, String>
    ): String? {
        return converterDemo.uploadFile("https://api.example.com/upload", file, additionalData)
    }

    @PostMapping("/converters/text")
    fun sendPlainText(@RequestBody text: String): String? {
        return converterDemo.sendPlainText("https://api.example.com/text", text)
    }
}
