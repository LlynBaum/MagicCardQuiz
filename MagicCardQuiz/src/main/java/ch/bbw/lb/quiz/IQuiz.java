package ch.bbw.lb.quiz;

import java.util.Map;

public interface IQuiz {
    void start();
    Map<String, Integer> getNextQuestion();
    boolean checkAnswer(int index);
    Statistics end();
}
