package dk.zealand;

public class GradeCalculator {
    public String getGrade(int score) {
        if (score < 0 || score > 199) {
            throw new IllegalArgumentException("Score must be between 0 and 199");
        }

        if (score >= 101) {
            return "Surb";
        }

        if (score >= 90) {
            return "A";
        }
        if (score >= 80) {
            return "B";
        }
        if (score >= 70) {
            return "C";
        }
        if (score >= 60) {
            return "D";
        }
        return "F";
    }
}
