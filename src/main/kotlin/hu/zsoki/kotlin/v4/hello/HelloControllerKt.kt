package hu.zsoki.kotlin.v4.hello

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HelloControllerKt {

    @GetMapping("/hello_kotlin")
    fun helloWorld(@RequestParam name: String): ResponseEntity<String> {
        return ResponseEntity.ok("Hello, $name")
    }
}