package com.bugsbunny.taskmanagerecs.controller;

import com.bugsbunny.taskmanagerecs.dto.TaskRequestDto;
import com.bugsbunny.taskmanagerecs.dto.TaskResponseDto;
import com.bugsbunny.taskmanagerecs.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
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

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getAllTasks() {
        List<TaskResponseDto> responseDtos = taskService.getAllTasks();
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable Long taskId) {
        TaskResponseDto responseDto = taskService.getTaskById(taskId);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/status")
    public ResponseEntity<List<TaskResponseDto>> getAllTasksByStatus(@RequestParam String status) {
        List<TaskResponseDto> responseDtos = taskService.getAllTasksByStatus(status);
        return ResponseEntity.ok(responseDtos);
    }

    @PatchMapping("/{taskId}")
    public ResponseEntity<TaskResponseDto> updateTask(@PathVariable Long taskId, @RequestBody TaskRequestDto taskRequestDto) {
        TaskResponseDto responseDto = taskService.updateTaskById(taskId, taskRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long taskId) {
        taskService.deleteTaskById(taskId);
        return ResponseEntity.noContent().build();
    }
}
