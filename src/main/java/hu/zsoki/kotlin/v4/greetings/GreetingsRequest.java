package hu.zsoki.kotlin.v4.greetings;

public class GreetingsRequest {

    private String languageCode;
    private String name;

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
