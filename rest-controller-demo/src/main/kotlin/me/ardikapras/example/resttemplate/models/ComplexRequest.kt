package me.ardikapras.example.resttemplate.models

data class ComplexRequest(
    val id: Long,
    val productId: Long,
    val name: String,
    val items: List<String>
)
