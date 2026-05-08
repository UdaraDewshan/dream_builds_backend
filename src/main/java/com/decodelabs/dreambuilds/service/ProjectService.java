package com.decodelabs.dreambuilds.service;

import com.decodelabs.dreambuilds.dto.ProjectDto;
import com.decodelabs.dreambuilds.entity.ProjectEntity;
import com.decodelabs.dreambuilds.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public ProjectDto createProject(ProjectDto projectDto) {
        ProjectEntity entity = new ProjectEntity();
        entity.setTitle(projectDto.getTitle());
        entity.setClientName(projectDto.getClientName());
        entity.setBudget(projectDto.getBudget());

        ProjectEntity savedEntity = projectRepository.save(entity);
        projectDto.setId(savedEntity.getId());
        return projectDto;
    }

    public List<ProjectDto> getAllProjects() {
        return projectRepository.findAll().stream().map(entity -> {
            ProjectDto dto = new ProjectDto();
            dto.setId(entity.getId());
            dto.setTitle(entity.getTitle());
            dto.setClientName(entity.getClientName());
            dto.setBudget(entity.getBudget());
            return dto;
        }).collect(Collectors.toList());
    }

    public ProjectDto updateProject(Long id, ProjectDto projectDto) {
        Optional<ProjectEntity> optionalEntity = projectRepository.findById(id);

        if (optionalEntity.isPresent()) {
            ProjectEntity entity = optionalEntity.get();
            entity.setTitle(projectDto.getTitle());
            entity.setClientName(projectDto.getClientName());
            entity.setBudget(projectDto.getBudget());

            ProjectEntity updatedEntity = projectRepository.save(entity);
            projectDto.setId(updatedEntity.getId());
            return projectDto;
        }
        return null;
    }

    public boolean deleteProject(Long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}