package ch.bbw.lb.quiz;

import ch.bbw.lb.db.CostsQueryHandler;

import java.util.Map;

public class CostsQuiz implements IQuiz {

    private final CostsQueryHandler costsQueryHandler;

    public CostsQuiz(String userName) {
        costsQueryHandler = new CostsQueryHandler(userName);
    }

    @Override
    public void start() {
        System.out.println("Costs quiz started");
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
