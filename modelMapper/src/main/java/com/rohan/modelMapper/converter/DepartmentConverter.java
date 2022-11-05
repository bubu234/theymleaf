package com.rohan.modelMapper.converter;

import com.rohan.modelMapper.dto.DepartmentDto;
import com.rohan.modelMapper.dto.DepartmentResponseDto;
import com.rohan.modelMapper.model.Department;

public interface DepartmentConverter {
    Department departmentToProject(DepartmentDto departmentDto);
    DepartmentResponseDto departmentToDepartmentResponseDto(Department department);
}
