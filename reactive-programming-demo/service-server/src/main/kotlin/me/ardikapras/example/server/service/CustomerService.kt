package me.ardikapras.example.server.service

import me.ardikapras.example.server.model.CustomerResponse
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import java.time.Duration
import kotlin.random.Random

@Service
class CustomerService {
    private val firstNames = listOf("John", "Jane", "Bob", "Alice", "Charlie", "Diana", "Edward", "Fiona")
    private val lastNames = listOf("Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis")
    private val domains = listOf("gmail.com", "yahoo.com", "hotmail.com", "outlook.com")

    fun getCustomersInParallel(customerIds: List<String>): Flux<CustomerResponse> {
        return Flux.fromIterable(customerIds)
            .parallel()
            .runOn(Schedulers.boundedElastic())
            .flatMap { customerId ->
                processCustomer(customerId)
            }
            .sequential()
    }

    fun getCustomersInSequential(customerIds: List<String>): Flux<CustomerResponse> {
        return Flux.fromIterable(customerIds)
            .flatMap { customerId ->
                processCustomer(customerId)
            }
    }

    private fun processCustomer(customerId: String): Mono<CustomerResponse> {
        val processingTime = getRandomDelay()
        return Mono.just(customerId)
            .delayElement(Duration.ofMillis(processingTime))
            .map { id -> generateCustomerData(id) }
    }

    private fun generateCustomerData(id: String): CustomerResponse {
        val firstName = firstNames.random()
        val lastName = lastNames.random()
        val domain = domains.random()

        return CustomerResponse(
            customerId = id,
            name = "$firstName $lastName",
            email = "${firstName.lowercase()}.${lastName.lowercase()}@$domain"
        )
    }

    private fun getRandomDelay(): Long {
        return Random.nextLong(1000, 10000)
    }
}
