package com.example.TP_CRUDGestion_des_Taches.Views;
import com.example.TP_CRUDGestion_des_Taches.Tasks.Task;
import com.example.TP_CRUDGestion_des_Taches.Tasks.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @Autowired
    public TaskRepository taskRepository;
    @GetMapping("/viewalltasks")
    public String taskList(Model model) {
        Iterable<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "taskList";
    }
}
