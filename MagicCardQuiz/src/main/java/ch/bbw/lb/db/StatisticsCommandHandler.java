package ch.bbw.lb.db;

import org.bson.Document;

public class StatisticsCommandHandler extends DatabaseBase {

    private final String userName;

    public StatisticsCommandHandler(String userName) {
        this.userName = userName;
    }

    public void saveGameResult(int correctAnswers, int wrongAnswers, int durationInMilliseconds) {
        var collection = initMongoClient("statistics");
        var document = new Document()
                .append("userName", userName)
                .append("correctAnswers", correctAnswers)
                .append("wrongAnswers", wrongAnswers)
                .append("durationInMilliseconds", durationInMilliseconds);
        collection.insertOne(document);
    }

}
