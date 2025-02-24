package me.ardikapras.example.server.controller

import me.ardikapras.example.server.model.BatchCustomerRequest
import me.ardikapras.example.server.model.CustomerResponse
import me.ardikapras.example.server.service.CustomerService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/api/customers")
class CustomerController(private val customerService: CustomerService) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping("/batch")
    fun getCustomersInBatch(@RequestBody request: BatchCustomerRequest): Flux<CustomerResponse> {
        logger.info("Received batch request for ${request.customerIds.size} customers")
        return customerService.getCustomersInSequential(request.customerIds)
            .doOnComplete {
                logger.info("Completed processing batch request")
            }
    }
}
