package com.app.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DepartmentController {

    @GetMapping("/departments")
    public String listDepartments(){
        return "list-departments";
    }

//    @RequestMapping("/add")
//    public String addDepartment(){
//        return "add-department";
//    }
//
//    @RequestMapping("/save")
//    public String saveDepartment(){
//        return "redirect:/department/list";
//    }
//
//    @RequestMapping("/delete")
//    public String deleteDepartment(){
//        return "redirect:/department/list";
//    }
//
//    @RequestMapping("/update")
//    public String updateDepartment(){
//        return "update-department";
//    }

}
