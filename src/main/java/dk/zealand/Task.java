package dk.zealand;

public class Task {
    private final String title;
    private boolean done;

    public Task(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Titlen må ikke være tom");
        }
        this.title = title;
        this.done = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public String getStatus() {
        return done ? "færdig" : "ikke færdig";
    }

    @Override
    public String toString() {
        return "[" + getStatus() + "] " + title;
    }
}
