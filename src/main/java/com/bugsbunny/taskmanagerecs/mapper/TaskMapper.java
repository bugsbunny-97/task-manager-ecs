package com.bugsbunny.taskmanagerecs.mapper;

import com.bugsbunny.taskmanagerecs.dto.TaskRequestDto;
import com.bugsbunny.taskmanagerecs.dto.TaskResponseDto;
import com.bugsbunny.taskmanagerecs.entity.Task;

import java.time.LocalDateTime;

public class TaskMapper {

    public static Task mapTaskRequestDtoToTask(TaskRequestDto taskRequestDto) {
        Task task = new Task();
        task.setTitle(taskRequestDto.getTitle());
        task.setDescription(taskRequestDto.getDescription());
        task.setStatus(taskRequestDto.getStatus());
        task.setDueDate(taskRequestDto.getDueDate());
        task.setCreatedBy(taskRequestDto.getCreatedBy());
        task.setCreateAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return task;
    }

    public static TaskResponseDto mapTaskToResponseDto(Task task) {
        return new TaskResponseDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getDueDate(),
                task.getCreatedBy(),
                task.getCreateAt().toLocalDate()
        );
    }
}
