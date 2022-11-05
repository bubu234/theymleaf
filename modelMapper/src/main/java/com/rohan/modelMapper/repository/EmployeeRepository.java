package com.rohan.modelMapper.repository;

import com.rohan.modelMapper.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
