package com.bugsbunny.taskmanagerecs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDate dueDate;
    private String createdBy;
    private LocalDate createdAt;
}
