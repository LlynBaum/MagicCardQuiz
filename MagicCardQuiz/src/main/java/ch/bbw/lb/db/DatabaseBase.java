package ch.bbw.lb.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public abstract class DatabaseBase {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017/MagicCardQuiz";
    protected MongoClient mongoClient;

    protected MongoCollection<Document> initMongoClient(String collectionName) {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(CONNECTION_STRING);
        }
        return mongoClient.getDatabase("MagicCardQuiz").getCollection(collectionName);
    }

    protected void closeMongoClient() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }
}
