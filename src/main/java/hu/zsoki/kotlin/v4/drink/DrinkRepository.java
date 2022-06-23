package hu.zsoki.kotlin.v4.drink;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<DrinkEntity, String> {
}
