package com.decodelabs.dreambuilds.service;

import com.decodelabs.dreambuilds.dto.ProjectDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    private final List<ProjectDto> projectDatabase = new ArrayList<>();

    public List<ProjectDto> getAllProjects() {
        return projectDatabase;
    }

    public ProjectDto createProject(ProjectDto project) {
        projectDatabase.add(project);
        return project;
    }
}