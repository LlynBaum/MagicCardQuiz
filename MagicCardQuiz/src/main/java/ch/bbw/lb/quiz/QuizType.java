package ch.bbw.lb.quiz;

public enum QuizType {
    COST("cost"),
    POWER("power"),
    TOUGHNESS("toughness");

    private final String name;

    QuizType(String name) {
        this.name = name;
    }

    public String getPropertyName() {
        return name;
    }
}
