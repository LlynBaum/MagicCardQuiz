package ch.bbw.lb.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public abstract class DatabaseBase {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017/MagicCardQuiz";
    private String userName;
    protected MongoClient mongoClient;

    public DatabaseBase(String userName) {
        this.userName = userName;
    }

    protected MongoClient initMongoClient() {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(CONNECTION_STRING);
        }
        return mongoClient;
    }

    protected void closeMongoClient() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }
}
