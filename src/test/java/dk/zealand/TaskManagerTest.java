package dk.zealand;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    @Test
    void createTaskAddsTaskToList() {
        TaskManager manager = new TaskManager();
        manager.createTask("Ryd op");
        List<Task> tasks = manager.getTasks();
        assertEquals(1, tasks.size());
        assertEquals("Ryd op", tasks.get(0).getTitle());
    }

    @Test
    void newTaskIsNotDone() {
        TaskManager manager = new TaskManager();
        Task task = manager.createTask("Skriv rapport");
        assertFalse(task.isDone());
    }

    @Test
    void createTaskWithEmptyTitleThrows() {
        TaskManager manager = new TaskManager();
        assertThrows(IllegalArgumentException.class, () -> manager.createTask(""));
    }

    @Test
    void multipleTasksCanBeCreated() {
        TaskManager manager = new TaskManager();
        manager.createTask("Opgave 1");
        manager.createTask("Opgave 2");
        assertEquals(2, manager.getTasks().size());
    }
}
