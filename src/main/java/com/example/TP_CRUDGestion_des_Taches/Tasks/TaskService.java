package com.example.TP_CRUDGestion_des_Taches.Tasks;

import com.example.TP_CRUDGestion_des_Taches.Tasks.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Task> getApproachingDueDateTasks(Date currentDate) {
        String jpql = "SELECT t FROM Task t WHERE t.dueDate BETWEEN :startDate AND :endDate";
        TypedQuery<Task> query = entityManager.createQuery(jpql, Task.class);

        // Calculate the date range for approaching due tasks (e.g., tasks due in the next 3 days)
        Date startDate = currentDate; // Adjust as needed based on your business logic
        Date endDate = new Date(startDate.getTime() + (3 * 24 * 60 * 60 * 1000)); // Example: 3 days from currentDate

        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);

        return query.getResultList();
    }
}
