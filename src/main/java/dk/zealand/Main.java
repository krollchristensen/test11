    package dk.zealand;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Opgaveliste ---");
            System.out.println("1. Opret opgave");
            System.out.println("2. Vis alle opgaver");
            System.out.println("3. Afslut");
            System.out.print("Vælg: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.print("Titel på opgave: ");
                    String title = scanner.nextLine().trim();
                    try {
                        manager.createTask(title);
                        System.out.println("Opgave oprettet: " + title);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Fejl: " + e.getMessage());
                    }
                }
                case "2" -> manager.printTasks();
                case "3" -> running = false;
                default -> System.out.println("Ugyldigt valg.");
            }
        }

        scanner.close();
    }
}