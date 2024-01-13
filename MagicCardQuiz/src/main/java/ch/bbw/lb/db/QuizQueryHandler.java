package ch.bbw.lb.db;

import ch.bbw.lb.models.Card;
import ch.bbw.lb.models.QuizQueryResult;
import org.bson.Document;

import java.lang.reflect.Array;
import java.util.List;

public class QuizQueryHandler extends QueryHandlerBase {

    public QuizQueryHandler(String userName) {
        super(userName);
    }

    public QuizQueryResult getQuestion(String property) {
        try {
            var collection = initMongoClient("cards");

            var randomCards = collection.aggregate(List.of(
                    new Document("$sample", new Document("size", 3)),
                    new Document("$project", new Document("name", 1).append(property, 1)),
                    new Document("$sort", new Document(property, -1))
            ));

            var cards = randomCards.map(QuizQueryHandler::toCard).into(List.of());
            System.out.println("Got question: " + cards.get(0).getName());

            closeMongoClient();
            return new QuizQueryResult(cards.toArray(Card[]::new), cards.get(0).getName());

        } catch (Exception e) {
            System.out.println("Error while getting question: " + e.getMessage());
            return null;
        }
    }

    private static Card toCard(Document document) {
        return new Card(
                document.getString("name"),
                document.getString("type"),
                document.getString("rarity"),
                document.getInteger("cost"),
                document.getInteger("power"),
                document.getInteger("toughness")
        );
    }
}
