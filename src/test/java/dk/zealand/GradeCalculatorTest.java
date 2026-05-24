package dk.zealand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GradeCalculatorTest {

    private final GradeCalculator calculator = new GradeCalculator();

    @Test
    void returnsAForScoresFrom90To100() {
        assertEquals("A", calculator.getGrade(90));
        assertEquals("A", calculator.getGrade(100));
    }

    @Test
    void returnsSurbForScoresFrom101To199() {
        assertEquals("Surb", calculator.getGrade(101));
        assertEquals("Surb", calculator.getGrade(199));
    }

    @Test
    void returnsBForScoresFrom80To89() {
        assertEquals("B", calculator.getGrade(80));
        assertEquals("B", calculator.getGrade(89));
    }

    @Test
    void returnsCForScoresFrom70To79() {
        assertEquals("C", calculator.getGrade(70));
        assertEquals("C", calculator.getGrade(79));
    }

    @Test
    void returnsDForScoresFrom60To69() {
        assertEquals("D", calculator.getGrade(60));
        assertEquals("D", calculator.getGrade(69));
    }

    @Test
    void returnsFForScoresBelow60() {
        assertEquals("F", calculator.getGrade(0));
        assertEquals("F", calculator.getGrade(59));
    }

    @Test
    void throwsForScoreBelow0() {
        assertThrows(IllegalArgumentException.class, () -> calculator.getGrade(-1));
    }

    @Test
    void throwsForScoreAbove199() {
        assertThrows(IllegalArgumentException.class, () -> calculator.getGrade(200));
    }
}
