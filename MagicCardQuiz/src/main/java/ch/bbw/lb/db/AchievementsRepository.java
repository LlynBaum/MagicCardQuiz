package ch.bbw.lb.db;

import ch.bbw.lb.models.Achievement;
import org.bson.Document;

import java.util.List;

public class AchievementsRepository extends RepositoryBase {

    public Achievement getAchievement(int id) {
        var collection = initMongoClient("achievements");
        var pipeline = new Document("$match", new Document("id", id));

        var achievement = collection.aggregate(List.of(pipeline)).first();
        if(achievement == null) {
            return null;
        }
        return documentToAchievement(achievement);
    }

    private Achievement documentToAchievement(Document document) {
        return new Achievement(
                document.getInteger("id"),
                document.getString("name"),
                document.getString("description"));
    }
}
