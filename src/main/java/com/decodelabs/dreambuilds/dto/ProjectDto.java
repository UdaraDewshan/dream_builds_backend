package com.decodelabs.dreambuilds.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ProjectDto {


    @NotBlank(message = "Project title cannot be empty")
    private String title;

    @NotNull(message = "Budget is required")
    @Min(value = 1, message = "Budget must be greater than zero")
    private Double budget;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Double getBudget() { return budget; }
    public void setBudget(Double budget) { this.budget = budget; }
}