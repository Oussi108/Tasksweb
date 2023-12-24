package com.example.TP_CRUDGestion_des_Taches.Tasks;

import com.example.TP_CRUDGestion_des_Taches.Tasks.Task;
import jakarta.annotation.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // You can define custom query methods here if needed
    List<Task> findByPriority(Priority priority);

}