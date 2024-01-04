package com.example.TP_CRUDGestion_des_Taches.Tasks;
import org.springframework.ui.Model;
import jakarta.annotation.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class TaskcController {
///

    @Autowired
    private TaskRepository _TaskRepository; // Inject the TaskRepository here


    @GetMapping
    public Iterable<Task> getAllTasks() {
        return _TaskRepository.findAll();
    }
    @GetMapping("/taskList")
    public String taskList(Model model) {
        List<Task> tasks = _TaskRepository.findAll(); // Fetch tasks from repository
        model.addAttribute("tasks", tasks); // Add tasks to the model

        return "taskList"; // Return the name of the Thymeleaf template
    }
    @GetMapping("/by-priority")
    public ResponseEntity<List<Task>> getTasksByPriority(@RequestParam Priority priority) {
        try {
            List<Task> filteredTasks = _TaskRepository.findByPriority(priority);
            return ResponseEntity.ok(filteredTasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/tasks/{id}")
    public String getTaskById(@PathVariable Long id, Model model) {
        Task task = _TaskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        model.addAttribute("task", task);
        return "task-details";
    }


    @GetMapping("/tasks/update/{id}")
    public String updateTaskForm(@PathVariable Long id, Model model) {
        Task task = _TaskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        model.addAttribute("task", task);
        return "update-task";
    }

    @PostMapping("/tasks/update/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute("task") Task updatedTask) {
        Task task = _TaskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        // Update the task fields with the values from the updatedTask
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setPriority(updatedTask.getPriority());
        task.setDueDate(updatedTask.getDueDate());
        task.setCategory(updatedTask.getCategory());
        // Update other fields as needed

        _TaskRepository.save(task);
        return "redirect:/tasks";
    }



    @GetMapping("/tasks/delete/{id}")
    public String deleteTaskForm(@PathVariable Long id, Model model) {
        Task task = _TaskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        model.addAttribute("task", task);
        return "delete-task"; // Optionally, a confirmation page
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id) {
        Task task = _TaskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        _TaskRepository.delete(task);
        return "redirect:/tasks";
    }
    @GetMapping("/tasks/delete/{id}/confirm")
    public String deleteTaskConfirmation(@PathVariable Long id, Model model) {
        Task task = _TaskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        model.addAttribute("task", task);
        return "delete-confirmation";
    }
    @GetMapping("/tasks/create")
    public String showCreateTaskForm(Model model) {
        model.addAttribute("task", new Task()); // Initialize an empty task object for the form
        return "create-task";
    }

    @PostMapping("/tasks/create")
    public String createTask(@ModelAttribute("task") Task task) {
        // Save the task using the TaskRepository
        _TaskRepository.save(task);
        // Redirect to a task list or details page
        return "redirect:/taskList";
    }
}
