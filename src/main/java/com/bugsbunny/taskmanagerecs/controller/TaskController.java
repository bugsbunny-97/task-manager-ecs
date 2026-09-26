package com.bugsbunny.taskmanagerecs.controller;

import com.bugsbunny.taskmanagerecs.dto.TaskRequestDto;
import com.bugsbunny.taskmanagerecs.dto.TaskResponseDto;
import com.bugsbunny.taskmanagerecs.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto taskRequestDto) {
        TaskResponseDto responseDto = taskService.createTask(taskRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable Long taskId) {
        TaskResponseDto responseDto = taskService.getTaskById(taskId);
        return ResponseEntity.ok(responseDto);
    }
}
