package com.app.student.controllers;

import java.util.List;
import java.util.ArrayList;
import com.app.student.aplicacion.Departamento;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

//    private IDepartmentService departmentService;
//
//    public DepartmentController(IDepartmentService departmentService){
//        this.departmentService = departmentService;
//    }

    @GetMapping()
    public String listDepartments(Model model){
//        List<Department> departments = departmentService.getAllDepartments();

        List<Departamento> departments = new ArrayList<>();
        departments.add(new Departamento(1, "Cundinamarca"));
        departments.add(new Departamento(2, "Antioquia"));
        departments.add(new Departamento(3, "Valle del Cauca"));
        departments.add(new Departamento(4, "Santander"));
        departments.add(new Departamento(5, "Nariño"));

        model.addAttribute("departments", departments);

        return "department/list_departments";
    }

    @RequestMapping("/add")
    public String addDepartment(Model model){

        Departamento department = new Departamento();
        model.addAttribute("department", department);

        model.addAttribute("title", "Agregar Departamento");
        return "department/add_department";
    }

    @RequestMapping("/save")
    public String saveDepartment(@ModelAttribute Departamento department){
        System.out.println(department);
        // departmentService.saveDepartment(department);
        return "redirect:/departments";
    }

    @RequestMapping("/update/{id}")
    public String updateDepartment(@PathVariable int id, Model model){
        // Department department = departmentService.getDepartmentById(id);
        Departamento department = new Departamento(id, "Cundinamarca");
        model.addAttribute("department", department);

        model.addAttribute("title", "Editar Departamento");
        return "department/add_department";
    }

    @RequestMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable int id){
        // departmentService.deleteDepartment(id);

        System.out.println("Department with id: " + id + " was deleted");
        return "redirect:/departments";
    }



}
