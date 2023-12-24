package com.example.TP_CRUDGestion_des_Taches.Tasks;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("Task not found with id: " + id);
    }
}