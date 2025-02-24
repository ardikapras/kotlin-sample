package me.ardikapras.example.resttemplate.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class SimpleResponse(
    val message: String,
    val timestamp: Instant = Instant.now()
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ExternalApiResponse(
    val id: Long,
    @JsonProperty("user_name")
    val userName: String,
    val email: String,
    val details: Map<String, Any>? = null
)
