package com.rohan.modelMapper.service;

import com.rohan.modelMapper.converter.DepartmentConverter;
import com.rohan.modelMapper.dto.DepartmentDto;
import com.rohan.modelMapper.dto.DepartmentResponseDto;
import com.rohan.modelMapper.model.Department;
import com.rohan.modelMapper.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private DepartmentRepository departmentRepository;
    private DepartmentConverter departmentConverter;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentConverter departmentConverter) {
        this.departmentRepository = departmentRepository;
        this.departmentConverter = departmentConverter;
    }

    public List<DepartmentResponseDto> getAllDepartments(){
        List<Department> departmentList = departmentRepository.findAll();
        return departmentList.stream().map(departmentConverter :: departmentToDepartmentResponseDto).collect(Collectors.toList());
    }

    public void addDepartment(DepartmentDto departmentDto) {
        Department department = departmentConverter.departmentToProject(departmentDto);
        departmentRepository.save(department);
    }

    public void updateDepartment(DepartmentDto department, int id) {
        Department data = departmentRepository.findById(id).orElse(null);
        assert data != null;
        data.setDeptName(department.getDeptName());
        data.setLocation(department.getLocation());
        departmentRepository.save(data);
    }

    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }

}
