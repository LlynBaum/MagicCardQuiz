package ch.bbw.lb;

import ch.bbw.lb.quiz.CostsQuiz;
import ch.bbw.lb.quiz.IQuiz;
import ch.bbw.lb.quiz.PowerQuiz;
import ch.bbw.lb.quiz.ToughnessQuiz;

public class Main {
    public static void main(String[] args) {
        printTitle();

        while (true) {
            printMenu();
            var quiz = readInput();
            if(quiz == null) {
                continue;
            }
            quiz.start();
        }
    }

    private static IQuiz readInput() {
        var input = System.console().readLine();
        var categoryIndex = Integer.parseInt(input);

        switch (categoryIndex) {
            case 1:
                return new CostsQuiz();
            case 2:
                return new PowerQuiz();
            case 3:
                return new ToughnessQuiz();
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
}