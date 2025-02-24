package me.ardikapras.example.client.client

import me.ardikapras.example.model.BatchCustomerRequest
import me.ardikapras.example.model.CustomerResponse
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux

@Component
class CustomerClient(private val webClient: WebClient) {

    fun getCustomersInfo(customerIds: List<String>): Flux<CustomerResponse> {
        return webClient.post()
            .uri("/api/customers/batch")
            .bodyValue(BatchCustomerRequest(customerIds))
            .retrieve()
            .bodyToFlux(CustomerResponse::class.java)
    }
}
