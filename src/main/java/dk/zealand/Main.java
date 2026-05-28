package dk.zealand;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            GradeCalculator gradeCalculator = new GradeCalculator();
            boolean running = true;

            while (running) {
                System.out.println(getMenuText());
                System.out.print("Vælg en mulighed: ");
                String choice = scanner.nextLine().trim();
                running = processChoice(choice, scanner, System.out, gradeCalculator);
                System.out.println();
            }
        }
    }

    static String getMenuText() {
        return """
                ========== Menu ==========
                1) Tjek om et tal er lige/ulige
                2) Beregn karakter fra score
                3) Afslut
                ==========================
                """;
    }

    static boolean processChoice(String choice, Scanner scanner, PrintStream out, GradeCalculator gradeCalculator) {
        switch (choice) {
            case "1" -> {
                out.print("Indtast et tal: ");
                try {
                    int number = Integer.parseInt(scanner.nextLine().trim());
                    if (isEven(number)) {
                        out.println(number + " er et lige tal");
                    } else {
                        out.println(number + " er et ulige tal");
                    }
                } catch (NumberFormatException e) {
                    out.println("Ugyldigt tal. Prøv igen.");
                }
                return true;
            }
            case "2" -> {
                out.print("Indtast score (0-199): ");
                try {
                    int score = Integer.parseInt(scanner.nextLine().trim());
                    out.println("Karakter: " + gradeCalculator.getGrade(score));
                } catch (IllegalArgumentException e) {
                    out.println("Ugyldig score. Brug et heltal mellem 0 og 199.");
                }
                return true;
            }
            case "3" -> {
                out.println("Farvel!");
                return false;
            }
            default -> {
                out.println("Ugyldigt valg. Vælg 1, 2 eller 3.");
                return true;
            }
        }
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}