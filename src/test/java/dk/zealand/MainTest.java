package dk.zealand;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    private final GradeCalculator gradeCalculator = new GradeCalculator();

    @Test
    void menuTextContainsExpectedOptions() {
        String menu = Main.getMenuText();
        assertTrue(menu.contains("1) Tjek om et tal er lige/ulige"));
        assertTrue(menu.contains("2) Beregn karakter fra score"));
        assertTrue(menu.contains("3) Afslut"));
    }

    @Test
    void processChoiceOnePrintsEvenResult() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        Scanner scanner = new Scanner("4\n");

        boolean keepRunning = Main.processChoice("1", scanner, out, gradeCalculator);

        assertTrue(keepRunning);
        assertTrue(output.toString().contains("4 er et lige tal"));
    }

    @Test
    void processChoiceTwoPrintsGrade() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        Scanner scanner = new Scanner("90\n");

        boolean keepRunning = Main.processChoice("2", scanner, out, gradeCalculator);

        assertTrue(keepRunning);
        assertTrue(output.toString().contains("Karakter: A"));
    }

    @Test
    void processChoiceThreeStopsCli() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(output);
        Scanner scanner = new Scanner("");

        boolean keepRunning = Main.processChoice("3", scanner, out, gradeCalculator);

        assertFalse(keepRunning);
        assertTrue(output.toString().contains("Farvel!"));
    }
}
