package dk.zealand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();

    public Task createTask(String title) {
        Task task = new Task(title);
        tasks.add(task);
        return task;
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public void printTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Ingen opgaver.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
