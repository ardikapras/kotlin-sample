# Kotlin Spring Boot REST Controller Examples

This project demonstrates the fundamental concepts of REST controllers in Spring Boot using Kotlin.

## What's Included

### 1. HTTP Methods Demo (`HttpMethodDemoController`)
Demonstrates different HTTP methods supported by REST controllers:
```kotlin
@GetMapping("/demo")    // GET method
@PostMapping("/demo")   // POST method
@PutMapping("/demo")    // PUT method
@DeleteMapping("/demo") // DELETE method
@PatchMapping("/demo")  // PATCH method
```

Test examples:
```bash
# GET Method
curl http://localhost:8080/http-methods/demo

# POST Method
curl -X POST http://localhost:8080/http-methods/demo

# PUT Method
curl -X PUT http://localhost:8080/http-methods/demo

# DELETE Method
curl -X DELETE http://localhost:8080/http-methods/demo

# PATCH Method
curl -X PATCH http://localhost:8080/http-methods/demo
```

### 2. Request Parameters Demo (`RequestParamsDemoController`)
Shows different ways to handle request parameters:

#### Path Variables
```kotlin
// Single path variable
@GetMapping("/path/{id}")
fun pathVariableDemo(@PathVariable id: String)

// Multiple path variables
@GetMapping("/path/{id}/items/{itemId}")
fun multiplePathVariables(
    @PathVariable id: String,
    @PathVariable itemId: String
)
```

Test examples:
```bash
# Single path variable
curl http://localhost:8080/params-demo/path/123

# Multiple path variables
curl http://localhost:8080/params-demo/path/123/items/456
```

#### Request Parameters
```kotlin
// Required parameter
@GetMapping("/query")
fun requestParamDemo(@RequestParam name: String)

// Optional parameter with default value
@GetMapping("/query/optional")
fun optionalRequestParam(
    @RequestParam(required = false, defaultValue = "guest") name: String
)
```

Test examples:
```bash
# Required parameter
curl http://localhost:8080/params-demo/query?name=John

# Optional parameter (with default value 'guest')
curl http://localhost:8080/params-demo/query/optional
curl http://localhost:8080/params-demo/query/optional?name=John

# Multiple parameters
curl http://localhost:8080/params-demo/query/multiple?name=John&age=25
curl http://localhost:8080/params-demo/query/multiple?name=John    # age will be default 18
```

### 3. Request Body Demo (`RequestBodyDemoController`)
Examples of handling different types of request bodies:

```kotlin
// String body
@PostMapping("/string")
fun stringBody(@RequestBody content: String)

// Object body
@PostMapping("/message")
fun messageBody(@RequestBody message: Message)

// Complex object
@PostMapping("/complex")
fun complexBody(@RequestBody request: ComplexRequest)
```

Test examples:
```bash
# Using string content
curl -X POST \
  -H "Content-Type: text/plain" \
  -d "Hello World" \
  http://localhost:8080/body-demo/string

# Using simple JSON object
curl -X POST \
  -H "Content-Type: application/json" \
  -d '{"content":"Hello World"}' \
  http://localhost:8080/body-demo/message

# Using complex JSON object
curl -X POST \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "productId": 2,
    "name": "Test",
    "items": ["item1", "item2", "item3"]
  }' \
  http://localhost:8080/body-demo/complex
```

## Project Structure
```
src/main/kotlin/com/example/restcontroller/
├── RestControllerApplication.kt
├── controller/
│   ├── HttpMethodController.kt        # HTTP methods examples
│   ├── RequestParamsDemoController.kt # Request parameters examples
│   └── RequestBodyDemoController.kt   # Request body examples
└── model/                             # Data classes for requests
    ├── ComplexRequest.kt
    └── Message.kt
```

## Running the Project
```bash
./gradlew :rest-controller-demo:bootRun
```

The application will start on `http://localhost:8080`
