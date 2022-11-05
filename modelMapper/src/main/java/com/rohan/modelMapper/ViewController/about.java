package com.rohan.modelMapper.ViewController;

import com.rohan.modelMapper.dto.EmployeeDto;
import com.rohan.modelMapper.repository.DepartmentRepository;
import com.rohan.modelMapper.repository.EmployeeRepository;
import com.rohan.modelMapper.repository.ProjectRepository;
import com.rohan.modelMapper.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class about {
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeService employeeService;

    public about(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/about")
    public String index(Model model){
        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }
    @GetMapping("/signup")
    public String signup(Model model){
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("departments",departmentRepository.findAll());
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("projects", projectRepository.findAll());
        return "signup";
    }
    @PostMapping("/submit")
    public String submit(@ModelAttribute EmployeeDto employeeDto){
        employeeService.addEmployee(employeeDto);

        return "redirect:/about";
    }
    @GetMapping("/update/{id}")

    public String updateDetail(@PathVariable int id, Model model){
        EmployeeDto employeeDto=new EmployeeDto();
        model.addAttribute("employeeDto",employeeDto);
        model.addAttribute("empId", id);
        model.addAttribute("thisEmployee",employeeRepository.findById(id).get());
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("projects", projectRepository.findAll());

        return "update";
    }
    @PostMapping("/submitUpdate")
    public String submitUpadte(@ModelAttribute EmployeeDto employeeDto)
    {
        employeeService.updateEmployee(employeeDto, employeeDto.getId());
        return "redirect:/about";
    }
    @GetMapping("/delete/{id}")
    public String deleteDetails(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "redirect:/about";
    }


}
