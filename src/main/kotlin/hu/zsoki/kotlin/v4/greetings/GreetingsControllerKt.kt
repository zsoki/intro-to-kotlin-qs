package hu.zsoki.kotlin.v4.greetings

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class GreetingsControllerKt(private val greetingsRepository: GreetingsRepository) {

    @GetMapping("/greetings_kotlin")
    fun greetings(@RequestBody greetingsRequest: GreetingsRequestKt): ResponseEntity<String> {
        val greetingsMessage: String = greetingsRepository.findById(greetingsRequest.languageCode!!) // TODO eliminate'!!'
            .orElse(getDefaultGreetings())
            .message
        return ResponseEntity.ok(greetingsMessage + greetingsRequest.name)
    }

    private fun getDefaultGreetings(): GreetingsEntity {
        return GreetingsEntity().apply { message = "Hello, " }
    }
}
