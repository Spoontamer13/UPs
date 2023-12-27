package com.example.autoitog.Auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Данная аннотация указывает, то, что класс конфигарционный
@Configuration
public class MvcConfigg implements WebMvcConfigurer {

    // Метод для обработки путей и представлений
    public void addViewControllers(ViewControllerRegistry registry) {
        //Указания того, что при обращении к адресу /login высветится представление login
        registry.addViewController("/login").setViewName("login");
    }

}

