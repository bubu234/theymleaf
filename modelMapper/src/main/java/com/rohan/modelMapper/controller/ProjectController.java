package com.rohan.modelMapper.controller;

import com.rohan.modelMapper.dto.ProjectDto;
import com.rohan.modelMapper.dto.ProjectResponseDto;
import com.rohan.modelMapper.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public List<ProjectResponseDto> getAllProjects(){
        return projectService.getAllProjects();
    }

    @PostMapping("/projects")
    public void addProject(@RequestBody ProjectDto projectDto) {
        projectService.addProject(projectDto);
    }

    @PutMapping("/projects/{id}")
    public void updateProject(@RequestBody ProjectDto project, @PathVariable int id) {
        projectService.updateProject(project, id);
    }

    @DeleteMapping("/projects/{id}")
    public void deleteProject(@PathVariable int id) {
        projectService.deleteProject(id);
    }

}
