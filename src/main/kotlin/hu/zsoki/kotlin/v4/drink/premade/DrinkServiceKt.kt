//package hu.zsoki.kotlin.v4.drink.premade
//
//import org.springframework.stereotype.Service
//import org.springframework.transaction.annotation.Transactional
//import java.time.LocalDateTime
//
//private const val ETHANOL_DENSITY = 0.80207
//private const val ETHANOL_MOLECULAR_WEIGHT = 46.06844
//
//@Service
//class DrinkServiceKt(private val drinkRepository: DrinkRepositoryKt) {
//
//    @Transactional
//    fun addOrEditDrink(drinkRequest: DrinkRequestKt): DrinkEntityKt {
//        val drinkEntity = drinkRepository.findById(drinkRequest.name).orElse(DrinkEntityKt())
//
//        with(drinkEntity) {
//            name = drinkRequest.name
//            price = drinkRequest.price
//            capacity = drinkRequest.capacity
//            percent = drinkRequest.percent
//            edited = LocalDateTime.now()
//            efficiency = calculateEfficiency(this)
//        }
//
//        drinkRepository.save(drinkEntity)
//        return drinkEntity
//    }
//
//    fun getDrinks(drinkOrder: DrinkOrder?): List<DrinkEntityKt> {
//        val drinks = drinkRepository.findAll()
//        return when (drinkOrder) {
//            DrinkOrder.DEFAULT -> drinks
//            DrinkOrder.NAME -> drinks.sortedBy(DrinkEntityKt::name)
//            DrinkOrder.EDITED_DATE -> drinks.sortedBy(DrinkEntityKt::edited)
//            DrinkOrder.EFFICIENCY -> drinks.sortedBy(DrinkEntityKt::efficiency)
//            null -> drinks
//        }
//    }
//
//    private fun calculateEfficiency(drink: DrinkEntityKt): Double {
//        // TODO eliminate '!!'
//        return drink.price!! / (drink.capacity!! * drink.percent!! * (ETHANOL_DENSITY / ETHANOL_MOLECULAR_WEIGHT))
//    }
//
//}
