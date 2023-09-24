package com.example.petshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/index")
    public String mainPage(Model model) {
        return "index";
    }

    @GetMapping("/error")
    public String errorPage() {
        return "error";
    }
}
