package hu.zsoki.kotlin.v4.greetings;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GREETINGS")
public class GreetingsEntity {

    @Id
    private String languageCode;

    @Column(nullable = false)
    private String message;

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String language) {
        this.languageCode = language;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String greetings) {
        this.message = greetings;
    }
}
