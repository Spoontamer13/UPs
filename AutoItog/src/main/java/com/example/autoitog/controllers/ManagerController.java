package com.example.autoitog.controllers;

import com.example.autoitog.models.Role;
import com.example.autoitog.models.TypeFuel;
import com.example.autoitog.models.UserModel;
import com.example.autoitog.service.DAOService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@PreAuthorize("hasAnyAuthority('MANAGER')")
public class ManagerController {
    private final DAOService daoService;

    public ManagerController(DAOService daoService) {
        this.daoService = daoService;
    }

    //Users
    @GetMapping("/manager/indexUser")
    public String indexUser(Model model) {
        model.addAttribute("obj", daoService.getAll(UserModel.class));
        return "indexUser";
    }

    @GetMapping("/showUser/{id}")
    public String showUser(@PathVariable("id") int id, Model model){
        model.addAttribute("obj", daoService.get(id, UserModel.class));
        return "showUser";
    }

    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("obj", daoService.get(id, UserModel.class));
        return "editUser";
    }

    @PostMapping("/editUser/{id}")
    public String updateUser(@ModelAttribute("obj") UserModel model, @PathVariable("id") int id){
        daoService.update(id, model, UserModel.class);
        return "redirect:/manager/indexUser";
    }

    //Role
    @GetMapping("/manager/indexRole")
    public String indexRole(Model model) {
        model.addAttribute("obj", daoService.getAll(Role.class));
        return "indexRole";
    }

    @GetMapping("/showRole/{id}")
    public String showRole(@PathVariable("id") int id, Model model){
        model.addAttribute("obj", daoService.get(id, Role.class));
        return "showRole";
    }

    @GetMapping("/newRole")
    public String newRole(@ModelAttribute("obj") Role obj){
        return "newRole";
    }

    @PostMapping("/createRole")
    public String createRole(@ModelAttribute("obj") Role model){
        daoService.create(model);
        return "redirect:/manager/indexRole";
    }

    @GetMapping("/editRole/{id}")
    public String editRole(@PathVariable("id") int id, Model model){
        model.addAttribute("obj", daoService.get(id, Role.class));
        return "editRole";
    }

    @PostMapping("/editRole/{id}")
    public String updateRole(@ModelAttribute("obj") Role model, @PathVariable("id") int id){
        daoService.update(id, model, Role.class);
        return "redirect:/manager/indexRole";
    }

    @DeleteMapping("/deleteRole/{id}")
    public String deleteRole(@PathVariable("id") int id){
        daoService.delete(id, Role.class);
        return "redirect:/manager/indexRole";
    }
}
