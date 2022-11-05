package com.rohan.modelMapper.service;

import com.rohan.modelMapper.converter.EmployeeConverter;
import com.rohan.modelMapper.dto.EmployeeDto;
import com.rohan.modelMapper.dto.EmployeeResponseDto;
import com.rohan.modelMapper.dto.TestDto;
import com.rohan.modelMapper.model.Department;
import com.rohan.modelMapper.model.Employee;
import com.rohan.modelMapper.model.Project;
import com.rohan.modelMapper.repository.DepartmentRepository;
import com.rohan.modelMapper.repository.EmployeeRepository;
import com.rohan.modelMapper.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    private ProjectRepository projectRepository;
    private EmployeeConverter employeeConverter;


    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository,
                           ProjectRepository projectRepository, EmployeeConverter employeeConverter) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.projectRepository = projectRepository;
        this.employeeConverter = employeeConverter;
    }

    public List<EmployeeResponseDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(employeeConverter::employeeToEmployeeResponseDto).collect(Collectors.toList());
    }

    public void addEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeConverter.employeeDtoToEmployee(employeeDto);

        Optional<Department> dept = departmentRepository.findById(employeeDto.getDepartment_id());
        if (dept.isEmpty())
            System.out.println("No department joined!!!");
        employee.setDepartment(dept.get());

        List<TestDto> projectList = employeeDto.getProject_list();
        for (TestDto project : projectList) {
            Optional<Project> optionalProject = projectRepository.findById(project.getProject_id());
            employee.getProjects().add(optionalProject.get());
        }

        employeeRepository.save(employee);
    }

    public void updateEmployee(EmployeeDto employee, int id) {
        Optional<Employee> thisStudent = employeeRepository.findById(id);
        if (thisStudent.isEmpty())
            System.out.println("No Employee found!!!");
        Employee data = thisStudent.get();
        data.setName(employee.getName());
        data.setAddress(employee.getAddress());
        data.setDob(employee.getDob());
        data.setDepartment(departmentRepository.findById(employee.getDepartment_id()).get());
        List<Project> emptylist = new ArrayList<>();
        data.setProjects(emptylist);
        List<TestDto> getProjects = employee.getProject_list();
        for (TestDto project : getProjects) {
            Optional<Project> optionalProject = projectRepository.findById(project.getProject_id());
            data.getProjects().add(optionalProject.get());
        }

            data.setDoj(employee.getDoj());
            employeeRepository.save(data);
        }

        public void deleteEmployee( int id){
            employeeRepository.deleteById(id);
        }

    }

