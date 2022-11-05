package com.rohan.modelMapper.repository;

import com.rohan.modelMapper.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
