package com.example.petshop.services.impl;

import com.example.petshop.domain.Pet;
import com.example.petshop.domain.Species;
import com.example.petshop.repositories.PetRepo;
import com.example.petshop.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepo petRepo;

    @Autowired
    public PetServiceImpl(PetRepo petRepo) {
        this.petRepo = petRepo;
    }

    /**
     * Добавляет нового питомца.
     * @param pet информация о новом питомце.
     * @return запись о питомце после добавления.
     * @see Pet
     */
    public Pet addPet(Pet pet) {
        return petRepo.save(pet);
    }

    /**
     * Возвращает полный список питомцев.
     * @return список питомцев.
     * @see Pet
     */
    public List<Pet> getAllPets() {
        return petRepo.findAll();
    }

    /**
     * Возвращает определенного питомца по id.
     * @param id идентификатор питомца.
     * @return запись о питомце.
     * @see Pet
     */
    public Pet getPetById(Long id) {
        Optional<Pet> pet = petRepo.findById(id);
        if (pet.isPresent()) {
            return pet.get();
        }
        return null;
    }

    /**
     * Обновляет информацию о питомце.
     * @param id идентификатор питомца.
     * @param pet обновленная информация о питомце.
     * @return запись о питомце после обновления.
     * @see Pet
     */
    public Pet updatePet(Long id, Pet pet) {
        Optional<Pet> petLookup = petRepo.findById(id);
        if (petLookup.isPresent()) {
            return petRepo.save(pet);
        }
        return null;
    }

    /**
     * Удаляет информацию о питомце.
     * @param id идентификатор питомца.
     * @return информация о питомце до удаления.
     * @see Pet
     */
    public Pet removePet(Long id) {
        Optional<Pet> pet = petRepo.findById(id);
        if (pet.isPresent()) {
            petRepo.delete(pet.get());
            return pet.get();
        }
        return null;
    }
}
