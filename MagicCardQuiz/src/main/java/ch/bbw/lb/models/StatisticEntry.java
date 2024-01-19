package ch.bbw.lb.models;

import org.bson.Document;

public class StatisticEntry {

    private String userName;

    private int correctAnswers;

    private int wrongAnswers;

    private long durationInMilliseconds;

    public StatisticEntry(String userName, int correctAnswers, int wrongAnswers, long durationInMilliseconds) {
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
                document.getLong("durationInMilliseconds")
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

    public long getDurationInMilliseconds() {
        return durationInMilliseconds;
    }
}
