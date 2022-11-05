package com.rohan.modelMapper.ViewController;

import com.rohan.modelMapper.dto.ImageDto;
import com.rohan.modelMapper.model.Image;
import com.rohan.modelMapper.repository.DepartmentRepository;
import com.rohan.modelMapper.repository.EmployeeRepository;
import com.rohan.modelMapper.repository.ImageRepository;
import com.rohan.modelMapper.repository.ProjectRepository;
import com.rohan.modelMapper.service.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller

public class ImageController {
    private ImageService imageService;
    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    private ProjectRepository projectRepository;
    private ImageRepository imageRepository;


    public ImageController(ImageService imageService, EmployeeRepository employeeRepository,
                           DepartmentRepository departmentRepository,
                           ProjectRepository projectRepository,
                           ImageRepository imageRepository) {
        this.imageService = imageService;
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.projectRepository = projectRepository;
        this.imageRepository = imageRepository;
    }

    @GetMapping("/employees/about/{id}")
    public String index(@PathVariable int id, Model model) {
        ImageDto img = new ImageDto();
        model.addAttribute("img", img);
        model.addAttribute("image", imageService.getImageByEmployeeId(id));
        return "/new";
    }

}