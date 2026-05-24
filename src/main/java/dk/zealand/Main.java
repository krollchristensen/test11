    package dk.zealand;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Indtast et tal: ");
        int number = scanner.nextInt();

        if (isEven(number)) {
            System.out.println(number + " er et lige tal");
        } else {
            System.out.println(number + " er et ulige tal");
        }

        scanner.close();
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}