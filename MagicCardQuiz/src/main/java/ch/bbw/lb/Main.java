package ch.bbw.lb;

import ch.bbw.lb.quiz.Quiz;
import ch.bbw.lb.quiz.QuizType;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    private final static int ROUNDS = 5;
    private static String userName = null;
    private static final Scanner scanner = new Scanner(System.in);

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
                System.out.println("---------- Question " + (q + 1) + "/" + ROUNDS + " ----------");
                askQuestion(quiz);
            }
            var result = quiz.end();

            System.out.println("You had " + result.correctAnswers() + "/" + ROUNDS + " correct answers!");
            System.out.println("You had " + result.wrongAnswers() + "/" + ROUNDS + " wrong answers!");

            isPlayAgain = getPlayAgain();
        }
    }

    private static void askQuestion(Quiz quiz) {
        var question = quiz.getNextQuestion();

        if(question == null) {
            System.out.println("OOPS! Something went wrong!");
            return;
        }

        System.out.println(question.question());
        System.out.println("Choose one of the following answers:");

        var answers = question.answers();
        for (var i = 0; i < answers.length; i++) {
            System.out.println((i + 1) + ". " + answers[i]);
        }

        Integer answerIndex = null;

        while (answerIndex == null) {
            answerIndex = readInt();
        }

        var isCorrect = quiz.checkAnswer(question.answers()[answerIndex - 1]);
        var resultString = isCorrect ? "Correct!" : "Wrong!";
        System.out.println(resultString);
    }

    private static Quiz setUpQuiz() {

        Integer categoryIndex = null;

        while (categoryIndex == null) {
            categoryIndex = readInt();
        }

        switch (categoryIndex) {
            case 1:
                return new Quiz(userName, QuizType.COST);
            case 2:
                return new Quiz(userName, QuizType.POWER);
            case 3:
                return new Quiz(userName, QuizType.TOUGHNESS);
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
        var input = scanner.nextLine();
        return Objects.equals(input, "y");
    }

    private static void login() {
       while (userName == null || userName.isBlank()) {
           System.out.println("Please enter your username:");
           userName = scanner.nextLine();
       }
    }

    private static Integer readInt() {
        var input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number");
            System.out.println("Please provide a valid number");
            return null;
        }
    }
}