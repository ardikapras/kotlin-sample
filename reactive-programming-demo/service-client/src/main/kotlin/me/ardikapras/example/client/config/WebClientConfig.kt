package me.ardikapras.example.client.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {

    @Bean
    fun webClient(@Value("\${service-b.url}") serviceBUrl: String): WebClient {
        return WebClient.builder()
            .baseUrl(serviceBUrl)
            .build()
    }
}
