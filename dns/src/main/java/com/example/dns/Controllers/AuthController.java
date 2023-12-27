package com.example.dns.Controllers;

import com.example.dns.Models.Person;

import javax.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class AuthController {

    public String baseUrl = "http://localhost:8080/";

    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder(8);
    }

    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/Registration")
    public String Registration(Model model) {
        return "Registration";
    }

    @PostMapping("/Registration")
    private String Registration(@Valid Person person, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
        {
            return "/Registration";
        }
       person.setPassword(getPasswordEncoder().encode(person.getPassword()));
       Person result = getRestTemplate().postForObject(baseUrl+"signUp",person, Person.class);
       return "redirect:/Authorization";
    }
}
