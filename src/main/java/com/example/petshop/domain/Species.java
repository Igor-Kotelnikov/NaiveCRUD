package com.example.petshop.domain;

import jakarta.persistence.*;

/**
 * Справочная таблица - каталог видов питомцев.
 */
@Entity
@Table(name="species")
public class Species {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    /**
     * Создает пустой объект вида питомца.
     */
    public Species() {

    }

    /**
     * Создает объект вида питомца с параметрами.
     * @param id уникальный идентификатор вида в БД.
     * @param name название вида.
     */
    public Species(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Геттер идентификатора.
     * @return уникальный идентификатор вида.
     */
    public Long getId() {
        return id;
    }

    /**
     * Сеттер идентификатора.
     * @param id уникальный идентификатор вида в БД.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Геттер названия вида.
     * @return название вида.
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер названия вида.
     * @param name название вида.
     */
    public void setName(String name) {
        this.name = name;
    }
}
