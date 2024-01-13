package ch.bbw.lb.quiz;

import ch.bbw.lb.db.QuizQueryHandler;

public class CostsQuiz implements IQuiz {

    private final QuizQueryHandler quizQueryHandler;

    public CostsQuiz(String userName) {
        quizQueryHandler = new QuizQueryHandler(userName);
    }

    @Override
    public void start() {
        System.out.println("Costs quiz started");
    }

    @Override
    public QuizQuestion getNextQuestion() {

        return null;
    }

    @Override
    public boolean checkAnswer(int index) {
        return false;
    }

    @Override
    public QuizResult end() {
        return null;
    }
}
