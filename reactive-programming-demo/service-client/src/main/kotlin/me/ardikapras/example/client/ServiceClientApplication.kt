package me.ardikapras.example.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServiceClientApplication

fun main(args: Array<String>) {
    runApplication<ServiceClientApplication>(*args)
}
