package com.example.assignment4.Animal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Optional<Animal> getAnimalById(int id) {
        return animalRepository.findById(id);
    }

    public void addAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public void updateAnimal(int id, Animal animal) {
        Optional<Animal> existing = getAnimalById(id);
        if(existing.isPresent()){
            Animal toUpdate = existing.get();
            toUpdate.setName(animal.getName());
            toUpdate.setScientificName(animal.getScientificName());
            toUpdate.setSpecies(animal.getSpecies());
            toUpdate.setHabitat(animal.getHabitat());
            toUpdate.setDescription(animal.getDescription());
            animalRepository.save(toUpdate);
        }
    }

    public void deleteAnimalById(int id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> getAnimalsBySpecies(String species) {
        return animalRepository.findBySpecies(species);
    }

    public List<Animal> searchAnimalsByName(String name) {
        return animalRepository.findByNameContaining(name);
    }

}