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
@RequestMapping("/municipalities")
public class MunicipalityController {

//    private IMunicipalityService municipalityService;
//
//    public MunicipalityController(IMunicipalityService municipalityService){
//        this.municipalityService = municipalityService;
//    }

    @GetMapping()
    public String listMunicipalities(Model model){
        List<Departamento> municipalities = new ArrayList<>();
        municipalities.add(new Departamento(1, "Cundinamarca"));
        municipalities.add(new Departamento(2, "Antioquia"));
        municipalities.add(new Departamento(3, "Valle del Cauca"));
        municipalities.add(new Departamento(4, "Santander"));
        municipalities.add(new Departamento(5, "Nariño"));
        model.addAttribute("municipalities", municipalities);
        return "municipality/list_municipalities";
    }

    @RequestMapping("/add")
    public String addMunicipality(Model model){
        Departamento municipality = new Departamento();
        model.addAttribute("municipality", municipality);
        model.addAttribute("title", "Agregar Municipio");
        return "municipality/add_municipality";
    }

    @RequestMapping("/save")
    public String saveMunicipality(@ModelAttribute Departamento municipality){
        System.out.println(municipality);
        return "redirect:/municipalities";
    }

    @RequestMapping("/update/{id}")
    public String updateMunicipality(@PathVariable int id, Model model){
        Departamento municipality = new Departamento(id, "Cundinamarca");
        model.addAttribute("municipality", municipality);
        return "municipality/add_municipality";
    }

    @RequestMapping("/delete/{id}")
    public String deleteMunicipality(@PathVariable int id){
        System.out.println("Municipio eliminado con id: " + id);
        return "redirect:/municipalities";
    }
}
