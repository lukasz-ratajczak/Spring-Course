package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employees;

    @PostConstruct
    private void loadData(){
        Employee employee1 = new Employee(1,"Anna","Burzay","ann@luv2code");
        Employee employee2 = new Employee(2,"Emma","Goldstein","emm@luv2code");
        Employee employee3 = new Employee(3,"Felix","Werter","fel@luv2code");

        employees = new ArrayList<>();

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }


    @GetMapping("/list")
    public String listEmployees(Model model){

        model.addAttribute("employees", employees);

        return "list-employees";
    }

}
