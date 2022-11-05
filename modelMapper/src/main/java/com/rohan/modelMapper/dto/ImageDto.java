package com.rohan.modelMapper.dto;

import com.rohan.modelMapper.model.Employee;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

public class ImageDto {


    private int id;

    private MultipartFile profileImage;

    private String name;



    private int  employee_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MultipartFile getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(MultipartFile profileImage) {
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }
}