package com.decodelabs.dreambuilds.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjectDto {

    private Long id;

    @NotBlank(message = "Project title cannot be empty")
    private String title;

    @NotBlank(message = "Client name cannot be empty")
    private String clientName;

    @NotNull(message = "Budget is required")
    @Min(value = 1, message = "Budget must be greater than zero")
    private Double budget;

}