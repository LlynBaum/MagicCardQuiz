package ch.bbw.lb.db;

import org.bson.Document;

public class StatisticsQueryHandler extends QueryHandlerBase {

    private final String userName;

    public StatisticsQueryHandler(String userName) {
        this.userName = userName;
    }

    public void saveGameResult(int correctAnswers, int wrongAnswers) {
        var collection = initMongoClient("statistics");
        var document = new Document();
        document.append("username", userName);
        document.append("correctAnswers", correctAnswers);
        document.append("wrongAnswers", wrongAnswers);
        collection.insertOne(document);
    }
}
