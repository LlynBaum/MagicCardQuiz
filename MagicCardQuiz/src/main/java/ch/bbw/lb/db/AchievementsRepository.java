package ch.bbw.lb.db;

import ch.bbw.lb.models.Achievement;
import ch.bbw.lb.quiz.AchievementType;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.addToSet;

import java.util.ArrayList;
import java.util.List;

public class AchievementsRepository extends RepositoryBase {

    private final String userName;

    public AchievementsRepository(String userName) {
        this.userName = userName;
    }

    public void addAchievementToUser(AchievementType achievement) {
        int id = achievement.id();

        var collection = initMongoClient("achievements");
        collection.updateOne(
                eq("id", id),
                addToSet("users", userName)
        );
    }

    public Achievement[] getAchievementsFromUser() {
        var collection = initMongoClient("achievements");
        var matchStage = new Document("$match", new Document("users", userName));
        var result = collection.aggregate(List.of(matchStage)).into(new ArrayList<>());

        return documentToAchievement(result);
    }

    private Achievement[] documentToAchievement(List<Document> documents) {
        return documents.stream().map(Achievement::fromDb).toArray(Achievement[]::new);
    }
}
