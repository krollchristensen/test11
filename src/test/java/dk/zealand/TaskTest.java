package dk.zealand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void taskHasTitleAndIsNotDoneByDefault() {
        Task task = new Task("Køb mælk");
        assertEquals("Køb mælk", task.getTitle());
        assertFalse(task.isDone());
        assertEquals("ikke færdig", task.getStatus());
    }

    @Test
    void throwsWhenTitleIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Task(""));
    }

    @Test
    void throwsWhenTitleIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Task("   "));
    }

    @Test
    void throwsWhenTitleIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null));
    }

    @Test
    void toStringIncludesTitleAndStatus() {
        Task task = new Task("Læs bog");
        assertEquals("[ikke færdig] Læs bog", task.toString());
    }
}
