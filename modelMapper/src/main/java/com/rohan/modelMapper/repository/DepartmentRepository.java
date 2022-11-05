package com.rohan.modelMapper.repository;

import com.rohan.modelMapper.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
