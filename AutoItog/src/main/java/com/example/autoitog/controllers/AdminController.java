package com.example.autoitog.controllers;

import com.example.autoitog.models.*;
import com.example.autoitog.service.DAOService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AdminController {
    private final DAOService daoService;

    public AdminController(DAOService daoService) {
        this.daoService = daoService;
    }

    //Brand
    @GetMapping("/admin/indexBrand")
    public String indexBrand(Model model) {
        model.addAttribute("brand", daoService.getAll(Brand.class));
        return "indexBrand";
    }

    @GetMapping("/showBrand/{id}")
    public String showBrand(@PathVariable("id") int id, Model model){
        model.addAttribute("brand", daoService.get(id, Brand.class));
        return "showBrand";
    }

    @GetMapping("/newBrand")
    public String newBrand(@ModelAttribute("brand") Brand obj){
        return "newBrand";
    }

    @PostMapping("/createBrand")
    public String createBrand(@ModelAttribute("brand") Brand model){
        daoService.create(model);
        return "redirect:/admin/indexBrand";
    }

    @GetMapping("/editBrand/{id}")
    public String editBrand(@PathVariable("id") int id, Model model){
        model.addAttribute("brand", daoService.get(id, Brand.class));
        return "editBrand";
    }

    @PostMapping("/editBrand/{id}")
    public String updateBrand(@ModelAttribute("brand") Brand model, @PathVariable("id") int id){
        daoService.update(id, model, Brand.class);
        return "redirect:/admin/indexBrand";
    }

    @DeleteMapping("/deleteBrand/{id}")
    public String deleteBrand(@PathVariable("id") int id){
        daoService.delete(id, Brand.class);
        return "redirect:/admin/indexBrand";
    }


    //ModelBrand
    @GetMapping("/admin/indexModelBrand")
    public String indexModelBrand(Model model) {
        model.addAttribute("obj", daoService.getAll(ModelBrand.class));
        return "indexModelBrand";
    }

    @GetMapping("/showModelBrand/{id}")
    public String showModelBrand(@PathVariable("id") int id, Model model){
        model.addAttribute("obj", daoService.get(id, ModelBrand.class));
        return "showModelBrand";
    }

    @GetMapping("/newModelBrand")
    public String newModelBrand(@ModelAttribute("obj") ModelBrand obj){
        return "newModelBrand";
    }

    @PostMapping("/createModelBrand")
    public String createModelBrand(@ModelAttribute("obj") ModelBrand model){
        daoService.create(model);
        return "redirect:/admin/indexModelBrand";
    }

    @GetMapping("/editModelBrand/{id}")
    public String editModelBrand(@PathVariable("id") int id, Model model){
        model.addAttribute("obj", daoService.get(id, ModelBrand.class));
        return "editModelBrand";
    }

    @PostMapping("/editModelBrand/{id}")
    public String updateModelBrand(@ModelAttribute("obj") ModelBrand model, @PathVariable("id") int id){
        daoService.update(id, model, ModelBrand.class);
        return "redirect:/admin/indexModelBrand";
    }

    @DeleteMapping("/deleteModelBrand/{id}")
    public String deleteModelBrand(@PathVariable("id") int id){
        daoService.delete(id, ModelBrand.class);
        return "redirect:/admin/indexModelBrand";
    }

    //BrandModelEngine
    @GetMapping("/admin/indexBrandModelEngine")
    public String indexBrandModelEngine(Model model) {
        model.addAttribute("obj", daoService.getAll(BrandModelEngine.class));
        return "indexBrandModelEngine";
    }

    @GetMapping("/showBrandModelEngine/{id}")
    public String showBrandModelEngine(@PathVariable("id") int id, Model model){
        model.addAttribute("obj", daoService.get(id, BrandModelEngine.class));
        return "showBrandModelEngine";
    }

    @GetMapping("/newBrandModelEngine")
    public String newBrandModelEngine(@ModelAttribute("obj") BrandModelEngine obj){
        return "newBrandModelEngine";
    }

    @PostMapping("/createBrandModelEngine")
    public String createBrandModelEngine(@ModelAttribute("obj") BrandModelEngine model){
        daoService.create(model);
        return "redirect:/admin/indexBrandModelEngine";
    }

    @GetMapping("/editBrandModelEngine/{id}")
    public String editBrandModelEngine(@PathVariable("id") int id, Model model){
        model.addAttribute("obj", daoService.get(id, BrandModelEngine.class));
        return "editBrandModelEngine";
    }

    @PostMapping("/editBrandModelEngine/{id}")
    public String updateBrandModelEngine(@ModelAttribute("obj") BrandModelEngine model, @PathVariable("id") int id){
        daoService.update(id, model, BrandModelEngine.class);
        return "redirect:/admin/indexBrandModelEngine";
    }

    @DeleteMapping("/deleteBrandModelEngine/{id}")
    public String deleteBrandModelEngine(@PathVariable("id") int id){
        daoService.delete(id, BrandModelEngine.class);
        return "redirect:/admin/indexBrandModelEngine";
    }

    //TypeBox
    @GetMapping("/admin/indexTypeBox")
    public String indexTypeBox(Model model) {
        model.addAttribute("obj", daoService.getAll(TypeBox.class));
        return "indexTypeBox";
    }

    @GetMapping("/showTypeBox/{id}")
    public String showTypeBox(@PathVariable("id") int id, Model model){
        model.addAttribute("obj", daoService.get(id, TypeBox.class));
        return "showTypeBox";
    }

    @GetMapping("/newTypeBox")
    public String newTypeBox(@ModelAttribute("obj") TypeBox obj){
        return "newTypeBox";
    }

    @PostMapping("/createTypeBox")
    public String createTypeBox(@ModelAttribute("obj") TypeBox model){
        daoService.create(model);
        return "redirect:/admin/indexTypeBox";
    }

    @GetMapping("/editTypeBox/{id}")
    public String editTypeBox(@PathVariable("id") int id, Model model){
        model.addAttribute("obj", daoService.get(id, TypeBox.class));
        return "editTypeBox";
    }

    @PostMapping("/editTypeBox/{id}")
    public String updateTypeBox(@ModelAttribute("obj") TypeBox model, @PathVariable("id") int id){
        daoService.update(id, model, TypeBox.class);
        return "redirect:/admin/indexTypeBox";
    }

    @DeleteMapping("/deleteTypeBox/{id}")
    public String deleteTypeBox(@PathVariable("id") int id){
        daoService.delete(id, TypeBox.class);
        return "redirect:/admin/indexTypeBox";
    }

    //TypeDrive
    @GetMapping("/admin/indexTypeDrive")
    public String indexTypeDrive(Model model) {
        model.addAttribute("obj", daoService.getAll(TypeDrive.class));
        return "indexTypeDrive";
    }

    @GetMapping("/showTypeDrive/{id}")
    public String showTypeDrive(@PathVariable("id") int id, Model model){
        model.addAttribute("obj", daoService.get(id, TypeDrive.class));
        return "showTypeDrive";
    }

    @GetMapping("/newTypeDrive")
    public String newTypeDrive(@ModelAttribute("obj") TypeDrive obj){
        return "newTypeDrive";
    }

    @PostMapping("/createTypeDrive")
    public String createTypeDrive(@ModelAttribute("obj") TypeDrive model){
        daoService.create(model);
        return "redirect:/admin/indexTypeDrive";
    }

    @GetMapping("/editTypeDrive/{id}")
    public String editTypeDrive(@PathVariable("id") int id, Model model){
        model.addAttribute("obj", daoService.get(id, TypeDrive.class));
        return "editTypeDrive";
    }

    @PostMapping("/editTypeDrive/{id}")
    public String updateTypeBox(@ModelAttribute("obj") TypeDrive model, @PathVariable("id") int id){
        daoService.update(id, model, TypeDrive.class);
        return "redirect:/admin/indexTypeDrive";
    }

    @DeleteMapping("/deleteTypeDrive/{id}")
    public String deleteTypeDrive(@PathVariable("id") int id){
        daoService.delete(id, TypeDrive.class);
        return "redirect:/admin/indexTypeDrive";
    }

    //TypeFuel
    @GetMapping("/admin/indexTypeFuel")
    public String indexTypeFuel(Model model) {
        model.addAttribute("obj", daoService.getAll(TypeFuel.class));
        return "indexTypeFuel";
    }

    @GetMapping("/showTypeFuel/{id}")
    public String showTypeFuel(@PathVariable("id") int id, Model model){
        model.addAttribute("obj", daoService.get(id, TypeFuel.class));
        return "showTypeFuel";
    }

    @GetMapping("/newTypeFuel")
    public String newTypeFuel(@ModelAttribute("obj") TypeFuel obj){
        return "newTypeFuel";
    }

    @PostMapping("/createTypeFuel")
    public String createTypeFuel(@ModelAttribute("obj") TypeFuel model){
        daoService.create(model);
        return "redirect:/admin/indexTypeFuel";
    }

    @GetMapping("/editTypeFuel/{id}")
    public String editTypeFuel(@PathVariable("id") int id, Model model){
        model.addAttribute("obj", daoService.get(id, TypeFuel.class));
        return "editTypeFuel";
    }

    @PostMapping("/editTypeFuel/{id}")
    public String updateTypeFuel(@ModelAttribute("obj") TypeFuel model, @PathVariable("id") int id){
        daoService.update(id, model, TypeFuel.class);
        return "redirect:/admin/indexTypeFuel";
    }

    @DeleteMapping("/deleteTypeFuel/{id}")
    public String deleteTypeFuel(@PathVariable("id") int id){
        daoService.delete(id, TypeFuel.class);
        return "redirect:/admin/indexTypeFuel";
    }
}
