package com.example.assignment4.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @GetMapping("/{id}")
    public Optional<Animal> getOneAnimal(@PathVariable int id){
        return animalService.getAnimalById(id);
    }

    @GetMapping("/species")
    public List<Animal> getAnimalBySpecies(@RequestParam(name = "species", defaultValue = "feline") String species){
        return animalService.getAnimalsBySpecies(species);
    }

    @PostMapping("/new")
    public List<Animal> addAnimal(@RequestBody Animal animal){
        animalService.addAnimal(animal);
        return animalService.getAllAnimals();
    }

    @PutMapping("/update/{id}")
    public Optional<Animal> updateAnimal(@PathVariable int id, @RequestBody Animal animal){
        animalService.updateAnimal(id, animal);
        return animalService.getAnimalById(id);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Animal>> searchAnimals(@RequestParam String name){
        List<Animal> animals = animalService.searchAnimalsByName(name);
        if(animals.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(animals);
    }

    @DeleteMapping("/delete/{id}")
    public List<Animal> deleteAnimalById(@PathVariable int id){
        animalService.deleteAnimalById(id);
        return animalService.getAllAnimals();
    }


}