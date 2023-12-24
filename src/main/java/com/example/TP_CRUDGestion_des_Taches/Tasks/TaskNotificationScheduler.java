package com.example.TP_CRUDGestion_des_Taches.Tasks;

import com.example.TP_CRUDGestion_des_Taches.Tasks.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;

@Component
public class TaskNotificationScheduler {

    @Autowired
    private TaskService taskService; // Inject your TaskService or repository here

    @Scheduled(fixedRate = 60000) // Run every minute (adjust as needed)
    public void checkDueDatesAndNotify() {
        List<Task> approachingTasks = taskService.getApproachingDueDateTasks(new Date());

        // Implement logic to send notifications for approachingTasks
        // You can use email, notifications in the UI, etc.
        // For example, send an email for each approaching task
        for (Task task : approachingTasks) {
            sendEmailNotification(task);
        }
    }

    private void sendEmailNotification(Task task) {
        // Implement email sending logic here
        // Use JavaMailSender or any email service to send notifications
    }
}
