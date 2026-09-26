package com.bugsbunny.taskmanagerecs.service;

import com.bugsbunny.taskmanagerecs.dto.TaskRequestDto;
import com.bugsbunny.taskmanagerecs.dto.TaskResponseDto;
import com.bugsbunny.taskmanagerecs.entity.Task;
import com.bugsbunny.taskmanagerecs.exception.TaskNotFoundException;
import com.bugsbunny.taskmanagerecs.repository.TaskRepository;
import org.springframework.stereotype.Service;

import static com.bugsbunny.taskmanagerecs.mapper.TaskMapper.mapTaskRequestDtoToTask;
import static com.bugsbunny.taskmanagerecs.mapper.TaskMapper.mapTaskToResponseDto;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponseDto createTask(TaskRequestDto taskRequestDto) {
        Task task = mapTaskRequestDtoToTask(taskRequestDto);
        return mapTaskToResponseDto(taskRepository.save(task));
    }

    public TaskResponseDto getTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + taskId));
        return mapTaskToResponseDto(task);
    }
}
