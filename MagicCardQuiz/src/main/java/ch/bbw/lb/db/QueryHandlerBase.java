package ch.bbw.lb.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public abstract class QueryHandlerBase {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017/MagicCardQuiz";
    protected MongoClient mongoClient;

    protected MongoCollection<Document> initMongoClient(String collectionName) {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(CONNECTION_STRING);
        }
        var collection = mongoClient.getDatabase("MagicCardQuiz").getCollection(collectionName);
        System.out.println("Connected to MongoDB!");
        return collection;
    }

    protected void closeMongoClient() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }
}
