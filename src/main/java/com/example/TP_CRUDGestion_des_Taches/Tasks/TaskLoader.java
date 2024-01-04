package com.example.TP_CRUDGestion_des_Taches.Tasks;

import com.example.TP_CRUDGestion_des_Taches.Tasks.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class TaskLoader implements CommandLineRunner {

    private final TaskRepository taskRepository;

    // Inject TaskRepository via constructor
    public TaskLoader(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) {

        Task task1 = new Task();
        task1.setTitle("Task 1");
        task1.setDescription("Description 1");
        task1.setPriority(Task.Priority.LOW);
        task1.setStatus(Task.Status.TODO);
        task1.setDueDate(new Date());
        task1.setCategory("Category 1");

        Task task2 = new Task();
        task2.setTitle("Task 2");
        task2.setDescription("Description 2");
        task2.setPriority(Task.Priority.MEDIUM);
        task2.setStatus(Task.Status.IN_PROGRESS);
        task2.setDueDate(new Date());
        task2.setCategory("Category 2");

        // Save tasks to the repository
        taskRepository.save(task1);
        taskRepository.save(task2);
        // Save other tasks as needed*/
    }
}
