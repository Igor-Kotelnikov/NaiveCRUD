package com.example.petshop.controllers;

import com.example.petshop.domain.Pet;
import com.example.petshop.domain.Species;
import com.example.petshop.services.PetService;
import com.example.petshop.services.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;
    private final SpeciesService speciesService;

    @Autowired
    PetController(PetService petService, SpeciesService speciesService) {
        this.petService = petService;
        this.speciesService = speciesService;
    }

    @GetMapping("/add")
    public String addPetForm(Model model) {
        model.addAttribute("species", speciesService.getAllSpecies());
        model.addAttribute("pet", new Pet());
        return "pets/add-pet";
    }

    @PostMapping("/add")
    public String addPet(Pet pet) {
        petService.addPet(pet);
        return "redirect:/pets";
    }

    @GetMapping()
    public String getAllPets(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "pets/show-pets-all";
    }

    @GetMapping("/{id}")
    public String getPetById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("pet", petService.getPetById(id));
        return "pets/show-pet";
    }

    @GetMapping("update/{id}")
    public String updatePetForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("pet", petService.getPetById(id));
        model.addAttribute("species", speciesService.getAllSpecies());
        return "pets/update-pet";
    }

    @PutMapping("/update/{id}")
    public String updatePet(@PathVariable("id") Long id, Pet pet) {
        petService.updatePet(id, pet);
        return "redirect:/pets";
    }

    @DeleteMapping("/delete/{id}")
    public String removePetById(@PathVariable("id") Long id) {
        petService.removePet(id);
        return "redirect:/pets";
    }
}
