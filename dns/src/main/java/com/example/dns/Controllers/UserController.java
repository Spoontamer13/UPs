package com.example.dns.Controllers;

import com.example.dns.Models.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/User")
@Controller
public class UserController {
    public String baseUrl = "http://localhost:8080/";
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/Index")
    public String UserIndex(Model model) {
        Product[] requestGetProduct = getRestTemplate().getForObject(baseUrl+"product", Product[].class);
        Shop[] requestGetShop = getRestTemplate().getForObject(baseUrl+"shop", Shop[].class);
        model.addAttribute("objectsProduct",requestGetProduct);
        model.addAttribute("objectsShop",requestGetShop);
        return "/User/Index";
    }

    @PostMapping("/Index")
    public String UserIndex(@RequestParam(name = "address",required = false) String address,
                            @RequestParam(name = "name", required = false) String name,
                            Model model) {
        Product[] requestGetProduct = getRestTemplate().getForObject(baseUrl+"product/"+address+"/"+name, Product[].class);
        Shop[] requestGetShop = getRestTemplate().getForObject(baseUrl+"shop", Shop[].class);
        model.addAttribute("objectsShop",requestGetShop);
        model.addAttribute("objectsProduct",requestGetProduct);
        return "/User/Index";
    }

    @GetMapping("/Product/{id}")
    public String ProductGet(@PathVariable(value = "id") Long id, Model model) {
        Product requestGetProduct = getRestTemplate().getForObject(baseUrl+"product/"+id, Product.class);
        Person[] requestGetPerson = getRestTemplate().getForObject(baseUrl+"person", Person[].class);
        model.addAttribute("objectProduct",requestGetProduct);
        model.addAttribute("objectPerson", requestGetPerson);
        return "/User/Product";
    }

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @PostMapping("/Product/{id}")
    public String ProductAddPerson(@PathVariable(value = "id") Long id,
                                    Person person, PersonShop personShop)
    {
        person.setUsername(getCurrentUsername());
        Person requestGetPerson = getRestTemplate().postForObject(baseUrl+"searchPerson",person ,Person.class);
        Product requestGetProduct = getRestTemplate().getForObject(baseUrl+"product/"+id, Product.class);
        personShop.setProduct(requestGetProduct);
        personShop.setPerson(requestGetPerson);
        PersonShop postPersonShop = getRestTemplate().postForObject(baseUrl+"personShop",personShop,PersonShop.class);
        return "redirect:/User/Index";
    }

    @GetMapping("/Order")
    public String UserOrder(Person person, Model model) {
        person.setUsername(getCurrentUsername());
        PersonShop[] requestGetShop = getRestTemplate().postForObject(baseUrl+"searchOrder",person ,PersonShop[].class);
        model.addAttribute("objectsPersonShop",requestGetShop);
        return "/User/Order";
    }
    @GetMapping("/Order/{id}")
    public String ProductDelete(@PathVariable(value = "id") Long id, Model model) {
        getRestTemplate().delete(baseUrl+"personShop/"+id);
        return "redirect:/User/Order";
    }
}
