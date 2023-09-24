package com.example.petshop.services.impl;

import com.example.petshop.domain.Species;
import com.example.petshop.repositories.SpeciesRepo;
import com.example.petshop.services.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class SpeciesServiceImpl implements SpeciesService {

    private final SpeciesRepo speciesRepo;
    private final Logger log = Logger.getLogger(SpeciesServiceImpl.class.getName());

    @Autowired
    public SpeciesServiceImpl(SpeciesRepo speciesRepo) {
        this.speciesRepo = speciesRepo;
    }

    /**
     * Добавляет новый вид.
     * @param species информация о новом виде.
     * @return запись о виде после добавления.
     * @see Species
     */
    public Species addSpecies(Species species) {
        return speciesRepo.save(species);
    }

    /**
     * Возвращает полный список видов.
     * @return список видов.
     * @see Species
     */
    public List<Species> getAllSpecies() {
        return speciesRepo.findAll();
    }

    /**
     * Возвращает определенный вид по id.
     * @param id идентификатор вида.
     * @return запись о виде.
     * @see Species
     */
    public Species getSpeciesById(Long id) {
        Optional<Species> species = speciesRepo.findById(id);
        if (species.isPresent()) {
            return species.get();
        }
        log.log(Level.SEVERE, "Вида с id " + id + " в базе данных не существует.");
        return null;
    }

    /**
     * Обновляет информацию о виде.
     * @param id идентификатор вида.
     * @param species обновленная информация о виде.
     * @return запись о виде после обновления.
     * @see Species
     */
    public Species updateSpecies(Long id, Species species) {
        Optional<Species> speciesLookup = speciesRepo.findById(id);
        if (speciesLookup.isPresent()) {
            return speciesRepo.save(species);
        }
        log.log(Level.SEVERE, "Вида с id " + id + " в базе данных не существует, запись не будет обновлена.");
        return null;
    }

    /**
     * Удаляет информацию о виде.
     * @param id идентификатор вида.
     * @return информация о виде до удаления.
     * @see Species
     */
    public Species removeSpecies(Long id) {
        Optional<Species> species = speciesRepo.findById(id);
        if (species.isPresent()) {
            speciesRepo.delete(species.get());
            return species.get();
        }
        log.log(Level.SEVERE, "Вида с id " + id + " в базе данных не существует, запись не будет удалена.");
        return null;
    }
}
