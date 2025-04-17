package com.todo.todoapp.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean completed;


}
