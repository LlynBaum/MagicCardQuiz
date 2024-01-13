package ch.bbw.lb.quiz;

import ch.bbw.lb.db.QuizQueryHandler;
import ch.bbw.lb.models.QuizQueryResult;

public class Quiz {

    private final QuizQueryHandler quizQueryHandler;

    private final QuizType quizType;

    private QuizQueryResult currentQuestion;

    private int correctAnswers = 0;
    private int wrongAnswers = 0;

    public Quiz(String userName, QuizType quizType) {
        quizQueryHandler = new QuizQueryHandler(userName);
        this.quizType = quizType;
    }

    public void start() {
        System.out.println("Costs quiz started");
    }

    public QuizQuestion getNextQuestion() {
        currentQuestion = quizQueryHandler.getQuestion(quizType.getPropertyName());
        return new QuizQuestion("What is the most expensive card?", new String[]{
                currentQuestion.cards()[0].getName(),
                currentQuestion.cards()[1].getName(),
                currentQuestion.cards()[2].getName()
        });
    }

    public boolean checkAnswer(String cardName) {
        var result = currentQuestion.nameOfCorrectCard().equals(cardName);
        if (result) {
            correctAnswers++;
        } else {
            wrongAnswers++;
        }
        return result;
    }

    public QuizResult end() {
        return new QuizResult(correctAnswers, wrongAnswers);
    }
}
