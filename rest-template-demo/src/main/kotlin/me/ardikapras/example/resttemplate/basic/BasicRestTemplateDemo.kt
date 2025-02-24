package me.ardikapras.example.resttemplate.basic

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import org.springframework.web.client.postForObject

@Service
class BasicRestTemplateDemo(
    private val restTemplate: RestTemplate
) {
    companion object {
        const val BASE_URL = "http://localhost:9999"
    }

    // Simple GET returning String
    fun getSimpleString(): String? {
        return restTemplate.getForObject<String>("$BASE_URL/api/basic/string")
    }

    // GET with ResponseEntity
    fun getWithResponseEntity(): ResponseEntity<String> {
        return restTemplate.getForEntity("$BASE_URL/api/basic/string", String::class.java)
    }

    // Simple POST with string body
    fun postString(requestBody: String): String? {
        return restTemplate.postForObject<String>("$BASE_URL/api/basic/post", requestBody)
    }

    // Basic error handling
    fun getWithErrorHandling(): Result<String> {
        return try {
            val response = restTemplate.getForObject<String>("$BASE_URL/api/error")
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
