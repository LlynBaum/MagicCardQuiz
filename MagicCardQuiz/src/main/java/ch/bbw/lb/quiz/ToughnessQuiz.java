package ch.bbw.lb.quiz;

import ch.bbw.lb.db.QuizQueryHandler;

public class ToughnessQuiz implements IQuiz {

    private final QuizQueryHandler quizQueryHandler;

    public ToughnessQuiz(String username) {
        quizQueryHandler = new QuizQueryHandler(username);
    }

    @Override
    public void start() {
        System.out.println("Toughness quiz started");
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
