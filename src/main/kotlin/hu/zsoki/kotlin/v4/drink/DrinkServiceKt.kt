package hu.zsoki.kotlin.v4.drink

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

private const val ETHANOL_DENSITY = 0.80207
private const val ETHANOL_MOLECULAR_WEIGHT = 46.06844

@Service
class DrinkServiceKt(private val drinkRepository: DrinkRepository) {

    @Transactional
    fun addOrEditDrink(drinkRequest: DrinkRequest): DrinkEntity {
        val drinkEntity = drinkRepository.findById(drinkRequest.name()).orElse(DrinkEntity())
        drinkEntity.name.javaClass

        with(drinkEntity) {
            name = drinkRequest.name()
            price = drinkRequest.price()
            capacity = drinkRequest.capacity()
            percent = drinkRequest.percent()
            edited = LocalDateTime.now()
            efficiency = calculateEfficiency(this)
        }

        drinkRepository.save(drinkEntity)
        return drinkEntity
    }

    fun getDrinks(drinkOrder: DrinkOrder?): List<DrinkEntity> {
        val drinks = drinkRepository.findAll()
        return when (drinkOrder) {
            DrinkOrder.DEFAULT -> drinks
            DrinkOrder.NAME -> drinks.sortedBy(DrinkEntity::getName)
            DrinkOrder.EDITED_DATE -> drinks.sortedBy(DrinkEntity::getEdited)
            DrinkOrder.EFFICIENCY -> drinks.sortedBy(DrinkEntity::getEfficiency)
            null -> drinks
        }
    }

    private fun calculateEfficiency(drink: DrinkEntity): Double {
        return drink.price / (drink.capacity * drink.percent * (ETHANOL_DENSITY / ETHANOL_MOLECULAR_WEIGHT))
    }

}
