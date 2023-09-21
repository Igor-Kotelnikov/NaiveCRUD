package com.example.petshop.services;

import com.example.petshop.domain.Pet;
import com.example.petshop.domain.Species;

import java.util.List;

public interface PetService {

    /**
     * Добавляет нового питомца.
     * @param pet информация о новом питомце.
     * @return запись о питомце после добавления.
     * @see Pet
     */
    Pet addPet(Pet pet);

    /**
     * Возвращает полный список питомцев.
     * @return список питомцев.
     * @see Pet
     */
    List<Pet> getAllPets();

    /**
     * Возвращает список питомцев указанного вида.
     * @param species вид питомцев.
     * @return список питомцев одного вида.
     * @see Pet
     * @see Species
     */
    List<Pet> getAllPetsBySpecies(Species species);

    /**
     * Возвращает определенного питомца по id.
     * @param id идентификатор питомца.
     * @return запись о питомце.
     * @see Pet
     */
    Pet getPetById(Long id);

    /**
     * Обновляет информацию о питомце.
     * @param id идентификатор питомца.
     * @param pet обновленная информация о питомце.
     * @return запись о питомце после обновления.
     * @see Pet
     */
    Pet updatePet(Long id, Pet pet);

    /**
     * Удаляет информацию о питомце.
     * @param id идентификатор питомца.
     * @return информация о питомце до удаления.
     * @see Pet
     */
    Pet removePet(Long id);
}
