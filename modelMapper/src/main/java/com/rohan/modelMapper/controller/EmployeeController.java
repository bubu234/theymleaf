package com.rohan.modelMapper.controller;

import com.rohan.modelMapper.dto.EmployeeDto;
import com.rohan.modelMapper.dto.EmployeeResponseDto;
import com.rohan.modelMapper.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<EmployeeResponseDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.addEmployee(employeeDto);
    }

    @PutMapping("/employees/{id}")
    public void updateEmployee(@RequestBody EmployeeDto employee, @PathVariable int id) {
        employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

}
