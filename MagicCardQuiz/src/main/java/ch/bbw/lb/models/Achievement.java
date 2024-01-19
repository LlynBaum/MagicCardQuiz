package ch.bbw.lb.models;

import org.bson.Document;

public record Achievement(int id, String name, String description) {

    public static Achievement fromDb(Document document) {
        return new Achievement(
                document.getInteger("id"),
                document.getString("name"),
                document.getString("description")
        );
    }
}
