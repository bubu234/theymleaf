package com.rohan.modelMapper.converter.impl;

import com.rohan.modelMapper.converter.EmployeeConverter;
import com.rohan.modelMapper.dto.EmployeeDto;
import com.rohan.modelMapper.dto.EmployeeResponseDto;
import com.rohan.modelMapper.model.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverterImpl implements EmployeeConverter {
    public final ModelMapper modelMapper;

    public EmployeeConverterImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, Employee.class);
    }

    @Override
    public EmployeeResponseDto employeeToEmployeeResponseDto(Employee employee) {
        return modelMapper.map(employee, EmployeeResponseDto.class);
    }

}
