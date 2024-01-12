package ch.bbw.lb.quiz;

public interface IQuiz {

    void start();
    void getNextQuestion();
    void checkAnswer(String answer);
    void end();
    void getStatistics();
}
