package hu.zsoki.kotlin.v4.drink;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DrinkController {

    private final DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @PostMapping("/add_drink")
    public ResponseEntity<DrinkEntity> addDrink(@RequestBody DrinkRequest drinkRequest) {
        return ResponseEntity.ok(drinkService.addOrEditDrink(drinkRequest));
    }

    @GetMapping("/get_drinks")
    public ResponseEntity<List<DrinkEntity>> getDrinks(@RequestParam DrinkOrder drinkOrder) {
        return ResponseEntity.ok(drinkService.getDrinks(drinkOrder));
    }

}
