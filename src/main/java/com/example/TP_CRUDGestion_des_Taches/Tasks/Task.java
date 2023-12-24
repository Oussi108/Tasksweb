package com.example.TP_CRUDGestion_des_Taches.Tasks;


import com.example.TP_CRUDGestion_des_Taches.User.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Task {
    @Id
    private Long id;
    private String title;
    private String description;

    // Constructeur
    public Task(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Task() {

    }
    public enum Priority {
        LOW, MEDIUM, HIGH
    }
    public enum Status {
        TODO, IN_PROGRESS, DONE
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Enumerated(EnumType.STRING)
    private Status status;

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Enumerated(EnumType.STRING)
    private Priority priority;
    // Getters et Setters pour chaque champ

    @Temporal(TemporalType.DATE)
    private Date dueDate;

    private String category;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @ManyToOne
    @JoinColumn(name = "user_id") // This column in the Task table references the User table
    private User user;
}

