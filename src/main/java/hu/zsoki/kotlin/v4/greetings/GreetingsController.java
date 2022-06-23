package hu.zsoki.kotlin.v4.greetings;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class GreetingsController {

    private final GreetingsRepository greetingsRepository;

    public GreetingsController(GreetingsRepository greetingsRepository) {
        this.greetingsRepository = greetingsRepository;
    }

    @GetMapping("/greetings")
    public ResponseEntity<String> greetings(@RequestBody GreetingsRequest greetingsRequest) {
        final String greetingsMessage = greetingsRepository.findById(greetingsRequest.getLanguageCode())
                .orElse(getDefaultGreetings())
                .getMessage();
        return ResponseEntity.ok(greetingsMessage + greetingsRequest.getName());
    }

    @NotNull
    private GreetingsEntity getDefaultGreetings() {
        final GreetingsEntity defaultGreetings = new GreetingsEntity();
        defaultGreetings.setMessage("Hello, ");
        return defaultGreetings;
    }
}
