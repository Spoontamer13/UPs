package com.example.autoitog.controllers;

import com.example.autoitog.models.Brand;
import com.example.autoitog.service.DAOService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final DAOService daoService;

    public MainController(DAOService daoService) {
        this.daoService = daoService;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN') or hasAnyAuthority('MANAGER') or hasAnyAuthority('USER')")
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
