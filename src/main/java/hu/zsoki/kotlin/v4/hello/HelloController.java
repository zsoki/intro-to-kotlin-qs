package hu.zsoki.kotlin.v4.hello;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld(@RequestParam String name) {
        return ResponseEntity.ok("Hello, " + name);
    }

}
