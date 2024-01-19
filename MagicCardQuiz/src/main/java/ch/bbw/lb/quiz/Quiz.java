package ch.bbw.lb.quiz;

import ch.bbw.lb.db.QuizQueryHandler;
import ch.bbw.lb.db.StatisticsCommandHandler;
import ch.bbw.lb.db.StatisticsQueryHandler;
import ch.bbw.lb.models.QuizQueryResult;

public class Quiz {

    private final QuizQueryHandler quizQueryHandler;

    private final StatisticsCommandHandler statisticsCommandHandler;
    private final StatisticsQueryHandler statisticsQueryHandler;

    private final QuizType quizType;

    private QuizQueryResult currentQuestion;

    private long startTime;

    private int correctAnswers = 0;
    private int wrongAnswers = 0;

    public Quiz(QuizType quizType, String userName) {
        quizQueryHandler = new QuizQueryHandler();
        statisticsCommandHandler = new StatisticsCommandHandler(userName);
        statisticsQueryHandler = new StatisticsQueryHandler();
        this.quizType = quizType;
    }

    public void start() {
        startTime = System.currentTimeMillis();
        System.out.println("Costs quiz started");
    }

    public QuizQuestion getNextQuestion() {
        currentQuestion = quizQueryHandler.getQuestion(quizType.getPropertyName());

        if(currentQuestion == null) {
            return null;
        }

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
        var endTime = System.currentTimeMillis();
        var durationInMilliseconds = endTime - startTime;

        statisticsCommandHandler.saveGameResult(correctAnswers, wrongAnswers, durationInMilliseconds);
        var statisticEntries = statisticsQueryHandler.getTopThree();

        return new QuizResult(correctAnswers, wrongAnswers, durationInMilliseconds, statisticEntries);
    }
}
