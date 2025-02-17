package me.ardikapras.example.rest.models

data class ComplexRequest(
    val id: Long,
    val productId: Long,
    val name: String,
    val items: List<String>
)
