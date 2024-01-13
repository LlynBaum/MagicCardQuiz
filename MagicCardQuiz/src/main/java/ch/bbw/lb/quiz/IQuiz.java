package ch.bbw.lb.quiz;

import java.util.Map;

public interface IQuiz {
    void start();
    QuizQuestion getNextQuestion();
    boolean checkAnswer(int index);
    QuizResult end();
}
