package ch.bbw.lb;

import ch.bbw.lb.quiz.CostsQuiz;
import ch.bbw.lb.quiz.IQuiz;
import ch.bbw.lb.quiz.PowerQuiz;
import ch.bbw.lb.quiz.ToughnessQuiz;

public class Main {

    private final static int ROUNDS = 5;
    private static String userName = null;

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        printTitle();
        login();

        while (true) {
            printMenu();
            var quiz = setUpQuiz();
            if(quiz == null) {
                continue;
            }
            quiz.start();

            for (var q = 0; q < ROUNDS; q++) {
                askQuestion(quiz);
            }
        }
    }

    private static void askQuestion(IQuiz quiz) {
        var question = quiz.getNextQuestion();

        for (var q : question.keySet()) {
            System.out.println("- " + q);
        }

        System.out.println(question);
        var answer = System.console().readLine();

        var answerIndex = question.get(answer);
        var isCorrect = quiz.checkAnswer(answerIndex);

        var resultString = isCorrect ? "Correct!" : "Wrong!";
        System.out.println(resultString);
    }

    private static IQuiz setUpQuiz() {
        var input = System.console().readLine();
        var categoryIndex = Integer.parseInt(input);

        switch (categoryIndex) {
            case 1:
                return new CostsQuiz(userName);
            case 2:
                return new PowerQuiz(userName);
            case 3:
                return new ToughnessQuiz(userName);
            default:
                System.out.println("Invalid category index");
                System.out.println("Please provide a valid category index");
                return null;
        }
    }

    private static void printMenu() {
        System.out.println("Select a category:");
        System.out.println("1. Costs");
        System.out.println("2. Power");
        System.out.println("3. Toughness");
    }

    private static void printTitle() {
        var title = "Magic Card Quiz";
        var titleLength = title.length();

        String topLine = "╔" + "=".repeat(titleLength + 2) + "╗";
        String middleLine = "║ " + title + " ║";
        String bottomLine = "╚" + "=".repeat(titleLength + 2) + "╝";

        System.out.println(topLine);
        System.out.println(middleLine);
        System.out.println(bottomLine);
    }

    private static void login() {
       while (userName.isBlank()) {
           System.out.println("Please enter your username:");
           userName = System.console().readLine();
       }
    }
}