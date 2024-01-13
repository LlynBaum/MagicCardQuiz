package ch.bbw.lb.quiz;

import ch.bbw.lb.db.QuizQueryHandler;

public class PowerQuiz implements IQuiz {

    private final QuizQueryHandler quizQueryHandler;

    public PowerQuiz(String username) {
        this.quizQueryHandler = new QuizQueryHandler(username);
    }

    @Override
    public void start() {
        System.out.println("Power quiz started");
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
