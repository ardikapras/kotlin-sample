package me.ardikapras.example.server.model

data class BatchCustomerRequest(
    val customerIds: List<String>
)

data class CustomerResponse(
    val customerId: String,
    val name: String,
    val email: String
)
