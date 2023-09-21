package com.example.petshop.services;

import com.example.petshop.domain.Species;

import java.util.List;

public interface SpeciesService {

    /**
     * Добавляет новый вид.
     * @param species информация о новом виде.
     * @return запись о виде после добавления.
     * @see Species
     */
    Species addSpecies(Species species);


    /**
     * Возвращает полный список видов.
     * @return список видов.
     * @see Species
     */
    List<Species> getAllSpecies();

    /**
     * Возвращает определенный вид по id.
     * @param id идентификатор вида.
     * @return запись о виде.
     * @see Species
     */
    Species getSpeciesById(Long id);

    /**
     * Обновляет информацию о виде.
     * @param id идентификатор вида.
     * @param species обновленная информация о виде.
     * @return запись о виде после обновления.
     * @see Species
     */
    Species updateSpecies(Long id, Species species);

    /**
     * Удаляет информацию о виде.
     * @param id идентификатор вида.
     * @return информация о виде до удаления.
     * @see Species
     */
    Species removeSpecies(Long id);

}
