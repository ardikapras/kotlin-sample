package me.ardikapras.example.resttemplate.controllers

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/params-demo")
class RequestParamsDemoController {

    // Path Variable examples
    @GetMapping("/path/{id}")
    fun pathVariableDemo(@PathVariable id: String) = "Path Variable value: $id"

    @GetMapping("/path/{id}/items/{itemId}")
    fun multiplePathVariables(
        @PathVariable id: String,
        @PathVariable itemId: String
    ) = "Path Variables - id: $id, itemId: $itemId"

    // Request Parameter examples
    @GetMapping("/query")
    fun requestParamDemo(@RequestParam name: String) = "Request Parameter value: $name"

    @GetMapping("/query/optional")
    fun optionalRequestParam(
        @RequestParam(required = false, defaultValue = "guest") name: String
    ) = "Optional Request Parameter value: $name"

    @GetMapping("/query/multiple")
    fun multipleRequestParams(
        @RequestParam name: String,
        @RequestParam(required = false, defaultValue = "18") age: Int
    ) = "Multiple Request Parameters - name: $name, age: $age"
}
