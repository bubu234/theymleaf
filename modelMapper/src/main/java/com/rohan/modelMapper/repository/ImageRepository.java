package com.rohan.modelMapper.repository;

import com.rohan.modelMapper.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.transaction.Transactional;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image,Integer> {
    Optional<Image> findByEmployeeId(int id);

    @Transactional
    void deleteByemployeeId(int id);
}
