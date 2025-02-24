package me.ardikapras.example.resttemplate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestControllerApplication

fun main(args: Array<String>) {
    runApplication<RestControllerApplication>(*args)
}