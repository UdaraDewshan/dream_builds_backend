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

    private int currentId = 1;

    public ProjectDto createProject(ProjectDto project) {
        project.setId(currentId++);
        projectDatabase.add(project);
        return project;
    }

    public ProjectDto updateProject(int id, ProjectDto updatedProject) {
        for (ProjectDto project : projectDatabase) {
            if (project.getId() == id) {
                project.setTitle(updatedProject.getTitle());
                project.setBudget(updatedProject.getBudget());
                return project;
            }
        }
        return null;
    }

    public boolean deleteProject(int id) {
        return projectDatabase.removeIf(project -> project.getId() == id);
    }
}