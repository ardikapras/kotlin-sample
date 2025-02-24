package me.ardikapras.example.resttemplate.converter

import org.springframework.core.io.FileSystemResource
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestTemplate
import java.io.File

@Service
class MessageConverterDemo(private val restTemplate: RestTemplate) {

    // JSON converter example
    fun sendJsonRequest(url: String, requestObj: Any): Any? {
        val headers = HttpHeaders().apply {
            contentType = MediaType.APPLICATION_JSON
        }
        val entity = HttpEntity(requestObj, headers)
        return restTemplate.postForObject(url, entity, Any::class.java)
    }

    // Form data
    fun sendFormData(url: String, formData: Map<String, String>): String? {
        val headers = HttpHeaders().apply {
            contentType = MediaType.APPLICATION_FORM_URLENCODED
        }

        val map = LinkedMultiValueMap<String, String>()
        formData.forEach { (key, value) -> map.add(key, value) }

        val entity = HttpEntity(map, headers)
        return restTemplate.postForObject(url, entity, String::class.java)
    }

    // Multipart file upload
    fun uploadFile(url: String, file: File, additionalData: Map<String, String>): String? {
        val headers = HttpHeaders().apply {
            contentType = MediaType.MULTIPART_FORM_DATA
        }

        val body = LinkedMultiValueMap<String, Any>().apply {
            add("file", FileSystemResource(file))
            additionalData.forEach { (key, value) -> add(key, value) }
        }

        val entity = HttpEntity(body, headers)
        return restTemplate.postForObject(url, entity, String::class.java)
    }

    // String converter with specific media type
    fun sendPlainText(url: String, text: String): String? {
        val headers = HttpHeaders().apply {
            contentType = MediaType.TEXT_PLAIN
        }
        val entity = HttpEntity(text, headers)
        return restTemplate.postForObject(url, entity, String::class.java)
    }
}
