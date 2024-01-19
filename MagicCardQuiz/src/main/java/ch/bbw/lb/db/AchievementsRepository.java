package ch.bbw.lb.db;

import ch.bbw.lb.models.Achievement;
import ch.bbw.lb.quiz.AchievementType;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AchievementsRepository extends RepositoryBase {

    private final String userName;

    public AchievementsRepository(String userName) {
        this.userName = userName;
    }

    public void addAchievementToUser(AchievementType achievement) {
        int id = achievement.id();

        var collection = initMongoClient("userAchievements");
        var existingUser = collection.find(new Document("userName", userName)).first();

        if (existingUser != null) {
            Document updateQuery = new Document("$push", new Document("achievementsIds", id));
            collection.updateOne(existingUser, updateQuery);
            return;
        }

        var pipeline = List.of(
                new Document("$match", new Document("userName", userName)),
                new Document("$unwind", "$achievementsIds"),
                new Document("$match", new Document("achievementsIds", id))
        );
        var result = collection.aggregate(pipeline).into(new ArrayList<>());
        if (!result.isEmpty()) {
            return;
        }

        Document newUser = new Document("userName", userName)
                .append("achievementsIds", List.of(id));
        collection.insertOne(newUser);
    }

    public Achievement[] getAchievementsFromUser() {
        var collection = initMongoClient("achievements");
        var pipeline = new Document("$match", new Document("userName", userName));

        var achievements = collection.aggregate(List.of(pipeline)).into(new ArrayList<>());
        return documentToAchievement(achievements);
    }

    private Achievement[] documentToAchievement(List<Document> documents) {
        return documents.stream().map(Achievement::fromDb).toArray(Achievement[]::new);
    }
}
