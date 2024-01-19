package ch.bbw.lb.quiz;

public enum AchievementType {
    FIRST_WIN(1),
    All_CORRECT_ANSWERS(2),
    ALL_WRONG_ANSWERS(3),
    TEN_GAMES(4),
    SPEEDRUNNER(5),
    SLOWPOKE(6),
    WARP_SPEED(7),
    THE_FLASH(8),
    CHEATER(9),
    IDENTITY_CRISIS(10);


    private final int id;

    AchievementType(int id) {
        this.id = id;
    }

    public int id() {
        return id;
    }
}
