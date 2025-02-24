package me.ardikapras.example.client.controller

import me.ardikapras.example.client.service.CustomerService
import me.ardikapras.example.model.CustomerRequest
import me.ardikapras.example.model.CustomerResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/api/customers")
class CustomerController(private val customerService: CustomerService) {

    @PostMapping("/inquiry")
    fun getCustomersInfo(@RequestBody request: CustomerRequest): Flux<CustomerResponse> {
        return customerService.processCustomers(request.customerIds)
    }
}
