package com.example.petshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class MainController {

    private final Logger log = Logger.getLogger(MainController.class.getName());

    @GetMapping("/index")
    public String mainPage(Model model) {
        log.log(Level.INFO, "Вызван обработчик запроса на получение главной страницы(GET-запрос)");
        return "index";
    }

    @GetMapping("/error")
    public String errorPage() {
        log.log(Level.WARNING, "Вызван обработчик запроса на страницу ошибки(GET-запрос)");
        return "error";
    }
}
