package com.todo.todoapp.Mapper;

import com.todo.todoapp.Dto.TaskDto;
import com.todo.todoapp.Entity.Task;

public class TaskMapper {
    public static TaskDto mapToTaskDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getCompleted()
        );
    }
    public static Task mapToTask (TaskDto taskDto){
        return new Task(
                taskDto.getId(),
                taskDto.getTitle(),
                taskDto.getCompleted()

        );
    }
}
