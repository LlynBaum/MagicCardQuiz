package ch.bbw.lb.db;

import ch.bbw.lb.models.StatisticEntry;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StatisticsRepository extends RepositoryBase {

    private final String userName;

    public StatisticsRepository(String userName) {
        this.userName = userName;
    }

    public void saveGameResult(int correctAnswers, int wrongAnswers, long durationInMilliseconds) {
        var collection = initMongoClient("statistics");
        var document = new Document()
                .append("userName", userName)
                .append("correctAnswers", correctAnswers)
                .append("wrongAnswers", wrongAnswers)
                .append("durationInMilliseconds", durationInMilliseconds);
        collection.insertOne(document);
    }

    public StatisticEntry[] getTopThree() {
        var collection = initMongoClient("statistics");

        var sortCriteria = new Document("correctAnswers", -1).append("durationInMilliseconds", 1);
        var groupFields = new Document("_id", null)
                .append("entries", new Document("$push", "$$ROOT"));

        var aggregationPipeline = new Document("$sort", sortCriteria);
        aggregationPipeline.append("$group", groupFields);
        aggregationPipeline.append("$project", new Document("bestEntries", new Document("$slice", Arrays.asList("$entries", 3))));

        var result = collection.aggregate(Collections
                        .singletonList(Document.parse(aggregationPipeline.toJson())))
                .into(new ArrayList<>());

        return mapToCards(result);
    }

    private static StatisticEntry[] mapToCards(List<Document> documents) {
        return documents.stream().map(StatisticEntry::fromDocument).toArray(StatisticEntry[]::new);
    }

}
