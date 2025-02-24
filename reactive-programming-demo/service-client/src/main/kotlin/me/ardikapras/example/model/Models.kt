package me.ardikapras.example.model

data class CustomerRequest(
    val customerIds: List<String>
)

data class BatchCustomerRequest(
    val customerIds: List<String>
)

data class CustomerResponse(
    val customerId: String,
    val name: String,
    val email: String
)
