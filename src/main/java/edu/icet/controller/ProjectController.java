package edu.icet.controller;

import edu.icet.dto.ProjectDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllProjects() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "System Pulse: Active");

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createProject(@Valid @RequestBody ProjectDto projectDto) {

        if (projectDto.getTitle().equalsIgnoreCase("test")) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid Project Title. Cannot use 'test'.");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Project created successfully");
        response.put("data", projectDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}