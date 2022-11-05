package com.rohan.modelMapper.converter;

import com.rohan.modelMapper.dto.ProjectDto;
import com.rohan.modelMapper.dto.ProjectResponseDto;
import com.rohan.modelMapper.model.Project;

public interface ProjectConverter {
    Project projectDtoToProject(ProjectDto projectDto);
    ProjectResponseDto projectToProjectResponseDto(Project project);
}
