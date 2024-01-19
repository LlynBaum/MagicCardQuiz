package ch.bbw.lb;

import ch.bbw.lb.quiz.Quiz;
import ch.bbw.lb.quiz.QuizResult;
import ch.bbw.lb.quiz.QuizType;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class QuizGame {

    private final static int ROUNDS = 5;
    private static String userName = null;
    private static final Scanner scanner = new Scanner(System.in);

    public static void play(String user) {
        userName = user;
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
            printResult(result);

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
        Collections.shuffle(Arrays.asList(answers));
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

    private static void printResult(QuizResult result) {
        System.out.println("---------- Result ----------");
        System.out.println("You took " + toSeconds(result.durationInMilliseconds()) + " seconds to answer all questions!");
        System.out.println("You had " + result.correctAnswers() + "/" + ROUNDS + " correct answers!");
        System.out.println("You had " + result.wrongAnswers() + "/" + ROUNDS + " wrong answers!");

        System.out.println("---------- Top 3 ----------");
        var topThree = result.topThree();

        for (var i = 0; i < topThree.length; i++) {
            var entry = topThree[i];
            System.out.println((i + 1) + ". " + entry.getUserName() + " - " + entry.getCorrectAnswers() + "/" + (entry.getCorrectAnswers() + entry.getWrongAnswers()) + " correct answers in " + toSeconds(entry.getDurationInMilliseconds()) + " seconds");
        }
    }

    private static Quiz setUpQuiz() {

        Integer categoryIndex = null;

        while (categoryIndex == null) {
            categoryIndex = readInt();
        }

        switch (categoryIndex) {
            case 1:
                return new Quiz(QuizType.COST, userName);
            case 2:
                return new Quiz(QuizType.POWER, userName);
            case 3:
                return new Quiz(QuizType.TOUGHNESS, userName);
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

    private static boolean getPlayAgain() {
        System.out.println("Do you want to play again? (y/n)");
        var input = scanner.nextLine();
        return Objects.equals(input, "y");
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

    private static int toSeconds(long milliseconds) {
        return (int) (milliseconds / 1000);
    }
}
