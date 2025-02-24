package me.ardikapras.example.resttemplate.config

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.options
import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.context.annotation.Configuration

@Configuration
class WireMockConfig {
    companion object {
        const val WIREMOCK_PORT = 9999
    }

    private val wireMockServer = WireMockServer(
        options()
            .port(WIREMOCK_PORT)
            .withRootDirectory("wiremock")
    )

    @PostConstruct
    fun setup() {
        wireMockServer.start()
    }

    @PreDestroy
    fun teardown() {
        wireMockServer.stop()
    }
}
