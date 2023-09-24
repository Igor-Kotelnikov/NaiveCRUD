package com.example.petshop.controllers;

import com.example.petshop.domain.Species;
import com.example.petshop.services.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/species")
public class SpeciesController {

    private final SpeciesService speciesService;

    @Autowired
    SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    @GetMapping("/add")
    public String addSpeciesForm(Model model) {
        model.addAttribute("species", new Species());
        return "species/add-species";
    }

    @PostMapping("/add")
    public String addSpecies(Species species) {
        speciesService.addSpecies(species);
        return "redirect:/species";
    }

    @GetMapping()
    public String getAllSpecies(Model model) {
        model.addAttribute("species", speciesService.getAllSpecies());
        return "species/show-species-all";
    }

    @GetMapping("/{id}")
    public String getSpeciesById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("species", speciesService.getSpeciesById(id));
        return "species/show-species";
    }

    @GetMapping("update/{id}")
    public String updateSpeciesForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("species", speciesService.getSpeciesById(id));
        return "species/update-species";
    }

    @PutMapping("update/{id}")
    public String updateSpecies(@PathVariable("id") Long id, Species species) {
        speciesService.updateSpecies(id, species);
        return "redirect:/species";
    }

    @DeleteMapping("/delete/{id}")
    public String removeSpeciesById(@PathVariable("id") Long id) {
        speciesService.removeSpecies(id);
        return "redirect:/species";
    }
}
