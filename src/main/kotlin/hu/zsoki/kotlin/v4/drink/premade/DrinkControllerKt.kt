//package hu.zsoki.kotlin.v4.drink.premade
//
//import hu.zsoki.kotlin.v4.drink.*
//import org.springframework.http.ResponseEntity
//import org.springframework.stereotype.Controller
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.RequestBody
//import org.springframework.web.bind.annotation.RequestParam
//
//@Controller
//class DrinkController(private val drinkService: DrinkServiceKt) {
//
//    @PostMapping("/add_drink")
//    fun addDrink(@RequestBody drinkRequest: DrinkRequestKt): ResponseEntity<DrinkEntityKt> {
//        return ResponseEntity.ok(drinkService.addOrEditDrink(drinkRequest))
//    }
//
//    @GetMapping("/get_drinks")
//    fun getDrinks(@RequestParam drinkOrder: DrinkOrder): ResponseEntity<List<DrinkEntityKt>> {
//        return ResponseEntity.ok(drinkService.getDrinks(drinkOrder))
//    }
//}