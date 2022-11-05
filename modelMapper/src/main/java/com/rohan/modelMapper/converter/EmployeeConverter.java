package com.rohan.modelMapper.converter;

import com.rohan.modelMapper.dto.EmployeeDto;
import com.rohan.modelMapper.dto.EmployeeResponseDto;
import com.rohan.modelMapper.model.Employee;

public interface EmployeeConverter {
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);
    EmployeeResponseDto employeeToEmployeeResponseDto(Employee employee);
}
