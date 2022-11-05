package com.rohan.modelMapper.converter.impl;

import com.rohan.modelMapper.converter.DepartmentConverter;
import com.rohan.modelMapper.dto.DepartmentDto;
import com.rohan.modelMapper.dto.DepartmentResponseDto;
import com.rohan.modelMapper.model.Department;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverterImpl implements DepartmentConverter {
    public final ModelMapper modelMapper;

    public DepartmentConverterImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Department departmentToProject(DepartmentDto departmentDto) {
        return modelMapper.map(departmentDto, Department.class);
    }

    @Override
    public DepartmentResponseDto departmentToDepartmentResponseDto(Department department) {
        return modelMapper.map(department, DepartmentResponseDto.class);
    }

}
