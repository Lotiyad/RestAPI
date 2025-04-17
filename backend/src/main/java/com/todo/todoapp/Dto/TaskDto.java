package com.todo.todoapp.Dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private Long id;
    private String title;
    private boolean completed;

    public Boolean getCompleted() {
        return completed;

    }
}
