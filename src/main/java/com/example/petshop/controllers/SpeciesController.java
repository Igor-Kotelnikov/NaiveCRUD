package com.example.petshop.controllers;

import com.example.petshop.domain.Species;
import com.example.petshop.services.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/species")
public class SpeciesController {

    private final SpeciesService speciesService;
    private final Logger log = Logger.getLogger(SpeciesController.class.getName());
    @Autowired
    SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    @GetMapping("/add")
    public String addSpeciesForm(Model model) {
        log.log(Level.INFO, "Вызван обработчик запроса на получение формы для создания новой записи о виде(GET-запрос, URL: /species/add)");
        model.addAttribute("species", new Species());
        return "species/add-species";
    }

    @PostMapping("/add")
    public String addSpecies(Species species) {
        log.log(Level.INFO, "Вызван обработчик запроса на создание новой записи о виде(POST-запрос, URL: /species/add)");
        speciesService.addSpecies(species);
        return "redirect:/species";
    }

    @GetMapping()
    public String getAllSpecies(Model model) {
        log.log(Level.INFO, "Вызван обработчик запроса на получение списка записей о видах(GET-запрос, URL: /species)");
        model.addAttribute("species", speciesService.getAllSpecies());
        return "species/show-species-all";
    }

    @GetMapping("/{id}")
    public String getSpeciesById(@PathVariable("id") Long id, Model model) {
        log.log(Level.INFO, "Вызван обработчик запроса на получение записи о виде по id(GET-запрос, URL: /species/{id})");
        model.addAttribute("species", speciesService.getSpeciesById(id));
        return "species/show-species";
    }

    @GetMapping("update/{id}")
    public String updateSpeciesForm(@PathVariable("id") Long id, Model model) {
        log.log(Level.INFO, "Вызван обработчик запроса на получение формы обновления записи о виде(GET-запрос, URL: /species/update/{id})");
        model.addAttribute("species", speciesService.getSpeciesById(id));
        return "species/update-species";
    }

    @PutMapping("update/{id}")
    public String updateSpecies(@PathVariable("id") Long id, Species species) {
        log.log(Level.INFO, "Вызван обработчик запроса на обновление записи о виде(PUT-запрос, URL: /species/update/{id})");
        speciesService.updateSpecies(id, species);
        return "redirect:/species";
    }

    @DeleteMapping("/delete/{id}")
    public String removeSpeciesById(@PathVariable("id") Long id) {
        log.log(Level.INFO, "Вызван обработчик запроса на удаление записи о виде(DELETE-запрос, URL: /species/delete/{id})");
        speciesService.removeSpecies(id);
        return "redirect:/species";
    }
}
