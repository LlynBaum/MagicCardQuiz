package ch.bbw.lb.db;

import ch.bbw.lb.models.Card;
import ch.bbw.lb.models.QuizQueryResult;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizRepository extends RepositoryBase {

    public QuizQueryResult getQuestion(String property) {
        try {
            var collection = initMongoClient("cards");

            var randomCards = collection.aggregate(List.of(
                    new Document("$sample", new Document("size", 3)),
                    new Document("$sort", new Document(property, -1)),
                    new Document("$project", new Document("name", 1).append(property, 1))
            )).into(new ArrayList<>());

            var cards = mapToCards(randomCards);
            closeMongoClient();
            return new QuizQueryResult(cards, cards[0].getName());

        } catch (Exception e) {
            System.out.println("Error while getting question: " + Arrays.toString(e.getStackTrace()));
            return null;
        }
    }

    private static Card[] mapToCards(List<Document> documents) {
        return documents.stream().map(Card::fromDb).toArray(Card[]::new);
    }
}
