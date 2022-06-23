package hu.zsoki.kotlin.v4.drink;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DrinkService {

    private static final Double ethanolDensity = 0.80207;
    private static final Double ethanolMolecularWeight = 46.06844;

    private final DrinkRepository drinkRepository;

    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Transactional
    public DrinkEntity addOrEditDrink(DrinkRequest drinkRequest) {
        final DrinkEntity drinkEntity = drinkRepository.findById(drinkRequest.name()).orElse(new DrinkEntity());
        drinkEntity.setName(drinkRequest.name());
        drinkEntity.setPrice(drinkRequest.price());
        drinkEntity.setCapacity(drinkRequest.capacity());
        drinkEntity.setPercent(drinkRequest.percent());
        drinkEntity.setEdited(LocalDateTime.now());

        final double efficiency = calculateEfficiency(drinkEntity);
        drinkEntity.setEfficiency(efficiency);

        drinkRepository.save(drinkEntity);
        return drinkEntity;
    }

    public List<DrinkEntity> getDrinks(DrinkOrder drinkOrder) {
        List<DrinkEntity> drinks = drinkRepository.findAll();

        switch (drinkOrder) {
            case DEFAULT:
                return drinks;
            case NAME:
                return drinks.stream()
                        .sorted(Comparator.comparing(DrinkEntity::getName))
                        .collect(Collectors.toList());
            case EDITED_DATE:
                return drinks.stream()
                        .sorted(Comparator.comparing(DrinkEntity::getEdited))
                        .collect(Collectors.toList());
            case EFFICIENCY:
                return drinks.stream()
                        .sorted(Comparator.comparing(DrinkEntity::getEfficiency))
                        .collect(Collectors.toList());
        }

        return drinks;
    }

    private double calculateEfficiency(DrinkEntity drink) {
        return drink.getPrice() / (drink.getCapacity() * drink.getPercent() * (ethanolDensity / ethanolMolecularWeight));
    }

}
