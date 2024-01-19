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

    public int getNumberOfGamesPlayed() {
        var collection = initMongoClient("statistics");
        var pipeline = new Document("$match", new Document("userName", userName));
        pipeline.append("$count", "numberOfGamesPlayed");

        var result = collection.aggregate(List.of(pipeline)).into(new ArrayList<>());
        return result.isEmpty() ? 0 : result.get(0).getInteger("numberOfGamesPlayed");
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

        var aggregationPipeline = Arrays.asList(
                new Document("$sort", sortCriteria),
                new Document("$group", groupFields),
                new Document("$project", new Document("bestEntries", new Document("$slice", Arrays.asList("$entries", 3))))
        );

        var result = collection.aggregate(aggregationPipeline).into(new ArrayList<>());
        return mapToCards(result.get(0).getList("bestEntries", Document.class));
    }

    private static StatisticEntry[] mapToCards(List<Document> documents) {
        return documents.stream().map(StatisticEntry::fromDocument).toArray(StatisticEntry[]::new);
    }

}
