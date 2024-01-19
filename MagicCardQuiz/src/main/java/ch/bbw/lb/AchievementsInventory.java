package ch.bbw.lb;

import ch.bbw.lb.db.AchievementsRepository;

public class AchievementsInventory {

    public static void show(String userName) {
        printTitle();
        var achievements = new AchievementsRepository(userName).getAchievementsFromUser();

        if (achievements.length == 0) {
            System.out.println("You have no achievements yet!");
            return;
        }

        for (var achievement : achievements) {
            System.out.println("---------- " + achievement.name() + " ----------");
            System.out.println(achievement.description());
            System.out.println();
        }
    }

    public static void printTitle() {
        var title = "Achievements";
        var titleLength = title.length();

        String topLine = "╔" + "=".repeat(titleLength + 2) + "╗";
        String bottomLine = "╚" + "=".repeat(titleLength + 2) + "╝";

        System.out.println(topLine);
        System.out.println("║ " + title + " ║");
        System.out.println(bottomLine);
    }

}
