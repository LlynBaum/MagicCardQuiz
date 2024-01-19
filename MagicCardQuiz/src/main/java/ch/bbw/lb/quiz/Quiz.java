package ch.bbw.lb.quiz;

import ch.bbw.lb.db.AchievementsRepository;
import ch.bbw.lb.db.QuizRepository;
import ch.bbw.lb.db.StatisticsRepository;
import ch.bbw.lb.models.QuizQueryResult;

public class Quiz {

    private final QuizRepository quizQueryHandler;

    private final StatisticsRepository statisticsRepository;

    private final AchievementsRepository achievementsRepository;

    private final QuizType quizType;

    private QuizQueryResult currentQuestion;


    private long questionStartTime;
    private long startTime;
    private int correctAnswers = 0;
    private int wrongAnswers = 0;

    public Quiz(QuizType quizType, String userName) {
        quizQueryHandler = new QuizRepository();
        statisticsRepository = new StatisticsRepository(userName);
        achievementsRepository = new AchievementsRepository(userName);
        this.quizType = quizType;
    }

    public void start() {
        startTime = System.currentTimeMillis();
        questionStartTime = startTime;
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
        var endTime = System.currentTimeMillis();
        var durationInMilliseconds = endTime - questionStartTime;
        if(durationInMilliseconds <= 1000) {
            achievementsRepository.addAchievementToUser(AchievementType.WARP_SPEED);
        }

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

        statisticsRepository.saveGameResult(correctAnswers, wrongAnswers, durationInMilliseconds);
        var statisticEntries = statisticsRepository.getTopThree();

        achievementsRepository.addAchievementToUser(AchievementType.FIRST_WIN);
        checkAchievements();
        checkTimeAchievements(durationInMilliseconds, correctAnswers);

        return new QuizResult(correctAnswers, wrongAnswers, durationInMilliseconds, statisticEntries);
    }

    private void checkAchievements() {
        if(correctAnswers == 0) {
            achievementsRepository.addAchievementToUser(AchievementType.ALL_WRONG_ANSWERS);
        }
        if(wrongAnswers == 0) {
            achievementsRepository.addAchievementToUser(AchievementType.All_CORRECT_ANSWERS);
        }
        if(statisticsRepository.getNumberOfGamesPlayed() == 10) {
            achievementsRepository.addAchievementToUser(AchievementType.TEN_GAMES);
        }
    }

    private void checkTimeAchievements(long durationInMilliseconds, int correctAnswers) {
        var seconds = durationInMilliseconds / 1000;

        if(seconds <= 25) {
            achievementsRepository.addAchievementToUser(AchievementType.SPEEDRUNNER);
        }
        if(seconds > 120) {
            achievementsRepository.addAchievementToUser(AchievementType.SLOWPOKE);
        }
        if(seconds <= 60) {
            achievementsRepository.addAchievementToUser(AchievementType.THE_FLASH);
        }
        if(correctAnswers == 5 && seconds <= 5) {
            achievementsRepository.addAchievementToUser(AchievementType.CHEATER);
        }
        if(correctAnswers == 0 && seconds <= 5) {
            achievementsRepository.addAchievementToUser(AchievementType.IDENTITY_CRISIS);
        }
    }
}
