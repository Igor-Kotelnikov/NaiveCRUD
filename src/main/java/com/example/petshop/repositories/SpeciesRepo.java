package com.example.petshop.repositories;

import com.example.petshop.domain.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepo extends JpaRepository<Species, Long> {
}
