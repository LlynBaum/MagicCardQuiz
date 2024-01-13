package ch.bbw.lb;

import ch.bbw.lb.quiz.CostsQuiz;
import ch.bbw.lb.quiz.IQuiz;
import ch.bbw.lb.quiz.PowerQuiz;
import ch.bbw.lb.quiz.ToughnessQuiz;

import java.util.Objects;

public class Main {

    private final static int ROUNDS = 5;
    private static String userName = null;

    public static void main(String[] args) {
        printTitle();
        login();

        var isPlayAgain = true;

        while (isPlayAgain) {
            printMenu();
            var quiz = setUpQuiz();
            if(quiz == null) {
                continue;
            }

            quiz.start();
            for (var q = 0; q < ROUNDS; q++) {
                System.out.println("----------" + " Question " + (q + 1) + "/" + ROUNDS + " ----------");
                askQuestion(quiz);
            }
            var result = quiz.end();

            System.out.println("You had " + result.correctAnswers() + "/" + ROUNDS + " correct answers!");
            System.out.println("You had " + result.wrongAnswers() + "/" + ROUNDS + " wrong answers!");

            isPlayAgain = getPlayAgain();
        }
    }

    private static void askQuestion(IQuiz quiz) {
        var question = quiz.getNextQuestion();

        System.out.println(question.getQuestion());
        System.out.println("Choose one of the following answers:");

        var answers = question.getAnswers();
        for (var i = 0; i < answers.length; i++) {
            System.out.println((i + 1) + ". " + answers[i]);
        }

        Integer answerIndex = null;

        while (answerIndex == null) {
            answerIndex = readInt();
        }

        var isCorrect = quiz.checkAnswer(answerIndex);
        var resultString = isCorrect ? "Correct!" : "Wrong!";
        System.out.println(resultString);
    }

    private static IQuiz setUpQuiz() {

        Integer categoryIndex = null;

        while (categoryIndex == null) {
            categoryIndex = readInt();
        }

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

    private static boolean getPlayAgain() {
        System.out.println("Do you want to play again? (y/n)");
        var input = System.console().readLine();
        return Objects.equals(input, "y");
    }

    private static void login() {
       while (userName.isBlank()) {
           System.out.println("Please enter your username:");
           userName = System.console().readLine();
       }
    }

    private static Integer readInt() {
        var input = System.console().readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
            System.out.println("Please provide a valid number");
            return null;
        }
    }
}