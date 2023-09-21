package com.example.petshop.domain;

import jakarta.persistence.*;

/**
 * Сущность, минимально описывающая питомца.<br>
 * Для каждой записи обязательно указывается кличка питомца, принадлежность к определенному виду и стоимость.<br>
 * Опционально описание с иной информацией - повадки, рекомендации по содержанию и т.п.
 */
@Entity
@Table(name="pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name="species_id", nullable = false)
    private Species species;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Double price;

    /**
     * Создает пустой объект питомца.
     */
    public Pet() {

    }

    /**
     * Создает объект питомца с указанными параметрами.
     * @param id уникальный идентификатор питомца в БД.
     * @param species вид питомца.
     * @param name кличка питомца.
     * @param description дополнительная информация о питомце.
     * @param price стоимость питомца.
     * @see Species
     */
    public Pet(Long id, Species species, String name, String description, Double price) {
        this.id = id;
        this.species = species;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * Геттер идентификатора.
     * @return уникальный идентификатор питомца в БД.
     */
    public Long getId() {
        return id;
    }

    /**
     * Сеттер идентификатора.
     * @param id уникальный идентификатор питомца в БД.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Геттер вида.
     * @return вид питомца.
     * @see Species
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * Сеттер вида.
     * @param species вид питомца.
     */
    public void setSpecies(Species species) {
        this.species = species;
    }

    /**
     * Геттер клички.
     * @return кличка питомца.
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер клички.
     * @param name кличка питомца.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер дополнительной информации.
     * @return дополнительная информация о питомце.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Сеттер дополнительной информации.
     * @param description дополнительная информация о питомце.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Геттер стоимости.
     * @return стоимость питомца.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Сеттер стоимости.
     * @param price стоимость питомца.
     */
    public void setPrice(Double price) {
        this.price = price;
    }
}
