package com.decodelabs.dreambuilds.controller;

import com.decodelabs.dreambuilds.dto.ProjectDto;
import com.decodelabs.dreambuilds.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllProjects() {
        Map<String, Object> response = new HashMap<>();

        List<ProjectDto> projects = projectService.getAllProjects();

        response.put("status", "success");
        response.put("data", projects);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createProject(@Valid @RequestBody ProjectDto projectDto) {

        if (projectDto.getTitle().equalsIgnoreCase("test")) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid Project Title. Cannot use 'test'.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        ProjectDto savedProject = projectService.createProject(projectDto);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Project created successfully");
        response.put("data", savedProject);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}