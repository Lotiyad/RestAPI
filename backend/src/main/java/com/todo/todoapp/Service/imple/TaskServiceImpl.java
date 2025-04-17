package com.todo.todoapp.Service.imple;

import com.todo.todoapp.Dto.TaskDto;
import com.todo.todoapp.Entity.Task;
import com.todo.todoapp.Mapper.TaskMapper;
import com.todo.todoapp.Repository.TaskRepository;
import com.todo.todoapp.Service.TaskService;
import com.todo.todoapp.exception.TaskNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    @Override
    public TaskDto createTask(TaskDto taskDto) {

        Task task = TaskMapper.mapToTask(taskDto);
       Task savedTask = taskRepository.save(task);
        return TaskMapper.mapToTaskDto(savedTask);
    }
    @Override
    public TaskDto getTaskById(Long taskId) {
        Task task =  taskRepository.findById(taskId)
                .orElseThrow(() ->
                        new RuntimeException("Task is not exists with the given id : " + taskId));
        return TaskMapper.mapToTaskDto(task);
    }



    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(TaskMapper::mapToTaskDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto updateTask(Long taskId, TaskDto updatedTask) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new TaskNotFound("Task is not exists with the given id : " + taskId)
        );
        task.setTitle(updatedTask.getTitle());
        task.setCompleted(updatedTask.getCompleted());

        Task updatedTaskObj = taskRepository.save(task);
        return TaskMapper.mapToTaskDto(updatedTaskObj);
    }

    @Override
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new TaskNotFound("Task is not exists with the given id : " + taskId)
        );
        taskRepository.deleteById(taskId);
    }
}
