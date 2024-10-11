package com.example.assignment4.Animal;



import com.example.assignment4.Animal.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findBySpecies(String species);

    @Query(value = "SELECT a FROM Animal a WHERE a.name LIKE %?1%", nativeQuery = true)
    List<Animal> findByNameContaining(String name);
}