package com.example.petshop.controllers;

import com.example.petshop.domain.Pet;
import com.example.petshop.services.PetService;
import com.example.petshop.services.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;
    private final SpeciesService speciesService;
    private final Logger log = Logger.getLogger(PetController.class.getName());

    @Autowired
    PetController(PetService petService, SpeciesService speciesService) {
        this.petService = petService;
        this.speciesService = speciesService;
    }

    @GetMapping("/add")
    public String addPetForm(Model model) {
        log.log(Level.INFO, "Вызван обработчик запроса на получение формы для создания новой записи о питомце(GET-запрос, URL: /pets/add)");
        model.addAttribute("species", speciesService.getAllSpecies());
        model.addAttribute("pet", new Pet());
        return "pets/add-pet";
    }

    @PostMapping("/add")
    public String addPet(Pet pet) {
        log.log(Level.INFO, "Вызван обработчик запроса на создание новой записи о питомце(POST-запрос, URL: /pets/add)");
        petService.addPet(pet);
        return "redirect:/pets";
    }

    @GetMapping()
    public String getAllPets(Model model) {
        log.log(Level.INFO, "Вызван обработчик запроса на получение списка записей о питомцах(GET-запрос, URL: /pets)");
        model.addAttribute("pets", petService.getAllPets());
        return "pets/show-pets-all";
    }

    @GetMapping("/{id}")
    public String getPetById(@PathVariable("id") Long id, Model model) {
        log.log(Level.INFO, "Вызван обработчик запроса на получение записи о питомце по id(GET-запрос, URL: /pets/{id})");
        model.addAttribute("pet", petService.getPetById(id));
        return "pets/show-pet";
    }

    @GetMapping("update/{id}")
    public String updatePetForm(@PathVariable("id") Long id, Model model) {
        log.log(Level.INFO, "Вызван обработчик запроса на получение формы обновления записи о питомце(GET-запрос, URL: /pets/update/{id})");
        model.addAttribute("pet", petService.getPetById(id));
        model.addAttribute("species", speciesService.getAllSpecies());
        return "pets/update-pet";
    }

    @PutMapping("/update/{id}")
    public String updatePet(@PathVariable("id") Long id, Pet pet) {
        log.log(Level.INFO, "Вызван обработчик запроса на обновление записи о питомце(PUT-запрос, URL: /pets/update/{id})");
        petService.updatePet(id, pet);
        return "redirect:/pets";
    }

    @DeleteMapping("/delete/{id}")
    public String removePetById(@PathVariable("id") Long id) {
        log.log(Level.INFO, "Вызван обработчик запроса на удаление записи о питомце(DELETE-запрос, URL: /pets/delete/{id})");
        petService.removePet(id);
        return "redirect:/pets";
    }
}
