package ch.bbw.lb.models;

import org.bson.Document;

public class StatisticEntry {

    private String userName;

    private int correctAnswers;

    private int wrongAnswers;

    private int durationInMilliseconds;

    public StatisticEntry(String userName, int correctAnswers, int wrongAnswers, int durationInMilliseconds) {
        this.userName = userName;
        this.correctAnswers = correctAnswers;
        this.wrongAnswers = wrongAnswers;
        this.durationInMilliseconds = durationInMilliseconds;
    }

    public static StatisticEntry fromDocument(Document document) {
        return new StatisticEntry(
                document.getString("userName"),
                document.getInteger("correctAnswers"),
                document.getInteger("wrongAnswers"),
                document.getInteger("durationInMilliseconds")
        );
    }

    public String getUserName() {
        return userName;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public int getDurationInMilliseconds() {
        return durationInMilliseconds;
    }
}
