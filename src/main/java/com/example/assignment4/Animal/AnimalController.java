package com.example.assignment4.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/all")
    public String getAllAnimals(Model model){
        model.addAttribute("animalList", animalService.getAllAnimals());
        model.addAttribute("title", "All Animals");
        return "animal-list";
    }

    @GetMapping("/{id}")
    public String getOneAnimal(@PathVariable int animalId, Model model){
        model.addAttribute("animal", animalService.getAnimalById(animalId));
        model.addAttribute("title", animalId);
        return "animal-details";
    }

    @GetMapping("/species")
    public String getAnimalBySpecies(@RequestParam(name = "species", defaultValue = "feline") String species, Model model){
        model.addAttribute("animalList", animalService.getAnimalsBySpecies(species));
        model.addAttribute("title", "Species Animals "+species);
        return "animal-list";
    }

    @PostMapping("/new")
    public String addAnimal(@RequestBody Animal animal){
        animalService.addAnimal(animal);
        return "redirect:/animals/all";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model){
        model.addAttribute("animal", animalService.getAnimalById(id));
        return "animal-update";
    }

    @PostMapping("/update")
    public String updateAnimal(Animal animal){
        animalService.addAnimal(animal);
        return "redirect:/amimals/" + animal.getAnimalId();
    }


    @GetMapping("/search")
    public Animal searchAnimals(@RequestParam String name){
        return (Animal) animalService.searchAnimalsByName(name);
    }

    @GetMapping("/delete/{id}")
    public String deleteAnimalById(@PathVariable int animalId){
        animalService.deleteAnimalById(animalId);
        return "redirect:/animals/all";

    }


}