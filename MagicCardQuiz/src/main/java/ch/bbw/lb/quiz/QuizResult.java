package ch.bbw.lb.quiz;

import ch.bbw.lb.models.StatisticEntry;

public record QuizResult(int correctAnswers, int wrongAnswers, long durationInMilliseconds, StatisticEntry[] topThree) {

}
