package ch.bbw.lb.db;

import org.bson.Document;

public class AchievementsRepository extends RepositoryBase {


    private final String userName;

    public AchievementsRepository(String userName) {
        this.userName = userName;
    }

    public void addAchievement(String name, String description) {
        var collection = initMongoClient("achievements");

        var document = new Document("userName", userName)
                .append("name", name)
                .append("description", description);
    }

}
