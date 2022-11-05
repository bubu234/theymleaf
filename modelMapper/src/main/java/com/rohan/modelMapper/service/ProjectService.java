package com.rohan.modelMapper.service;

import com.rohan.modelMapper.converter.ProjectConverter;
import com.rohan.modelMapper.dto.ProjectDto;
import com.rohan.modelMapper.dto.ProjectResponseDto;
import com.rohan.modelMapper.model.Department;
import com.rohan.modelMapper.model.Project;
import com.rohan.modelMapper.repository.DepartmentRepository;
import com.rohan.modelMapper.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;
    private DepartmentRepository departmentRepository;
    private ProjectConverter projectConverter;

    public ProjectService(ProjectRepository projectRepository, DepartmentRepository departmentRepository,
                          ProjectConverter projectConverter) {
        this.projectRepository = projectRepository;
        this.departmentRepository = departmentRepository;
        this.projectConverter = projectConverter;
    }

    public List<ProjectResponseDto> getAllProjects(){
        List<Project> projecteList = projectRepository.findAll();
        return projecteList.stream().map(projectConverter :: projectToProjectResponseDto).collect(Collectors.toList());
    }

    public void addProject(ProjectDto projectDto) {
        Project project = projectConverter.projectDtoToProject(projectDto);

        Optional<Department> dept = departmentRepository.findById(projectDto.getDepartment_id());
        if(dept.isEmpty())
            System.out.println("No department!!!");
        project.setDepartment(dept.get());

        projectRepository.save(project);
    }

    public void updateProject(ProjectDto department, int id) {
        Project data = projectRepository.findById(id).orElse(null);
        assert data != null;
        data.setProjectName(department.getProjectName());
        data.setDescription(department.getDescription());
        data.setDepartment(departmentRepository.findById(department.getDepartment_id()).get());
        projectRepository.save(data);
    }

    public void deleteProject(int id) {
        projectRepository.deleteById(id);
    }

}
