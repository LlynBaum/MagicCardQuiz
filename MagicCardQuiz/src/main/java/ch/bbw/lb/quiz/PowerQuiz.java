package ch.bbw.lb.quiz;

import ch.bbw.lb.db.PowerQueryHandler;

import java.util.Map;

public class PowerQuiz implements IQuiz {

    private final PowerQueryHandler powerQueryHandler;

    public PowerQuiz(String username) {
        this.powerQueryHandler = new PowerQueryHandler(username);
    }

    @Override
    public void start() {
        System.out.println("Power quiz started");
    }

    @Override
    public Map<String, Integer> getNextQuestion() {

        return null;
    }

    @Override
    public boolean checkAnswer(int index) {
        return false;
    }

    @Override
    public Statistics end() {
        return null;
    }
}
