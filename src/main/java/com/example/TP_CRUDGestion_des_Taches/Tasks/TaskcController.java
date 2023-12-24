package com.example.TP_CRUDGestion_des_Taches.Tasks;
import jakarta.annotation.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskcController {


    @Autowired
    private TaskRepository _TaskRepository; // Inject the TaskRepository here


    @GetMapping
    public Iterable<Task> getAllTasks() {
        return _TaskRepository.findAll();
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

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return _TaskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }


    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return _TaskRepository.save(task);
    }


    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Task task = _TaskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());

        return _TaskRepository.save(task);
    }


    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        Task task = _TaskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        _TaskRepository.delete(task);
    }
}
