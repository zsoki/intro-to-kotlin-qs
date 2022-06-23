package hu.zsoki.kotlin.v4.greetings;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingsRepository extends JpaRepository<GreetingsEntity, String> {
}
