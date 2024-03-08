package com.app.student.controllers;

import java.util.List;
import java.util.ArrayList;
import com.app.student.aplicacion.Departamento;
import com.app.student.aplicacion.Municipio;
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
        List<Municipio> municipalities = new ArrayList<>();
        municipalities.add(new Municipio(1, "Cundinamarca", 1));
        municipalities.add(new Municipio(2, "Antioquia", 1));
        municipalities.add(new Municipio(3, "Valle del Cauca", 1));
        municipalities.add(new Municipio(4, "Santander", 1));
        municipalities.add(new Municipio(5, "Nariño", 1));
        model.addAttribute("municipalities", municipalities);
        return "municipality/list_municipalities";
    }

    @RequestMapping("/add")
    public String addMunicipality(Model model){
        Municipio municipality = new Municipio();
        model.addAttribute("municipality", municipality);
        model.addAttribute("title", "Agregar Municipio");
        return "municipality/add_municipality";
    }

    @RequestMapping("/save")
    public String saveMunicipality(@ModelAttribute Municipio municipality){
        System.out.println(municipality);
        return "redirect:/municipalities";
    }

    @RequestMapping("/update/{id}")
    public String updateMunicipality(@PathVariable int id, Model model){
        Municipio municipality = new Municipio(id, "Cundinamarca", 1);
        model.addAttribute("municipality", municipality);
        return "municipality/add_municipality";
    }

    @RequestMapping("/delete/{id}")
    public String deleteMunicipality(@PathVariable int id){
        System.out.println("Municipio eliminado con id: " + id);
        return "redirect:/municipalities";
    }
}
