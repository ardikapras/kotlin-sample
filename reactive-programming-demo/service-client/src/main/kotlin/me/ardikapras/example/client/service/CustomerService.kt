package me.ardikapras.example.client.service

import me.ardikapras.example.client.client.CustomerClient
import me.ardikapras.example.model.CustomerResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.time.LocalDateTime

@Service
class CustomerService(private val customerClient: CustomerClient) {
    private val logger = LoggerFactory.getLogger(javaClass)

    fun processCustomers(customerIds: List<String>): Flux<CustomerResponse> {
        return customerClient.getCustomersInfo(customerIds)
            .doOnNext { customer ->
                logger.info("Received and processing customer: $customer")
                // Process each customer as it arrives
                processCustomer(customer)
            }
    }

    private fun processCustomer(response: CustomerResponse) {
        // Do your immediate processing here
        logger.info("Processing customer ${response.customerId} : ${response.name} at ${LocalDateTime.now()}")
    }
}
