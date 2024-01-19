package ch.bbw.lb;

import ch.bbw.lb.quiz.Quiz;
import ch.bbw.lb.quiz.QuizResult;
import ch.bbw.lb.quiz.QuizType;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static String userName = null;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printTitle();
        login();
        printMainMenu();

        var input = scanner.nextLine();

        while (!Objects.equals(input, "exit")) {
            var i = readInt(input);

            if(i == null) {
                input = scanner.nextLine();
                continue;
            }

            switch (i) {
                case 1 -> QuizGame.play(userName);
                case 2 -> AchievementsInventory.show(userName);
                case 3 -> System.exit(0);
                default -> System.out.println("Please enter a valid number!");
            }

            printMainMenu();
            input = scanner.nextLine();
        }

        QuizGame.play(userName);
    }

    private static Integer readInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Please enter a valid number!");
            return null;
        }
    }

    private static void printMainMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1. Play Quiz");
        System.out.println("2. Show Achievements");
        System.out.println("3. Exit");
    }

    private static void login() {
        while (userName == null || userName.isBlank()) {
            System.out.println("Please enter your username:");
            userName = scanner.nextLine();
        }
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