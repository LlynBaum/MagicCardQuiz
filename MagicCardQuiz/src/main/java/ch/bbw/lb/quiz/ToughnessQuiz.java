package ch.bbw.lb.quiz;

import java.util.Map;

public class ToughnessQuiz implements IQuiz {
    @Override
    public void start() {
        System.out.println("Toughness quiz started");
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
