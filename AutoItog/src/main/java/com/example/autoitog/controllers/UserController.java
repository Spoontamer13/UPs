package com.example.autoitog.controllers;

import com.example.autoitog.models.Car;
import com.example.autoitog.models.TypeFuel;
import com.example.autoitog.models.UserModel;
import com.example.autoitog.service.DAOService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@PreAuthorize("hasAnyAuthority('USER')")
public class UserController {
    private final DAOService daoService;

    public UserController(DAOService daoService) {
        this.daoService = daoService;
    }

    @GetMapping("/user/indexCar")
    public String indexCar(Model model) {
        model.addAttribute("obj", daoService.getAll(Car.class));
        return "indexCar";
    }

    @GetMapping("/showCar/{id}")
    public String showCar(@PathVariable("id") int id, Model model){
        model.addAttribute("obj", daoService.get(id, Car.class));
        return "showCar";
    }

    @GetMapping("/newCar")
    public String newCar(@ModelAttribute("obj") Car obj){
        return "newCar";
    }

    @PostMapping("/createCar")
    public String createCar(@ModelAttribute("obj") Car model){
        daoService.create(model);
        return "redirect:/user/indexCar";
    }

    @GetMapping("/editCar/{id}")
    public String editCar(@PathVariable("id") int id, Model model){
        model.addAttribute("obj", daoService.get(id, Car.class));
        return "editCar";
    }

    @PostMapping("/editCar/{id}")
    public String updateCar(@ModelAttribute("obj") Car model, @PathVariable("id") int id){
        daoService.update(id, model, Car.class);
        return "redirect:/user/indexCar";
    }

    @DeleteMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable("id") int id){
        daoService.delete(id, Car.class);
        return "redirect:/user/indexCar";
    }
}
