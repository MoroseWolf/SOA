package com.cyteam.api.dto;

import com.cyteam.api.model.Ingridients;
import com.cyteam.api.model.Menu;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class RecipeDTO {
    private Long id;
    private String name;
    private Double summ_calories;
    @JsonIgnore
    private Set<Menu> menuSet = new HashSet<>();
    private Set<Ingridients> ingridSet = new HashSet<>();

    public RecipeDTO() {}

    public RecipeDTO(Long id, String name, Double summ_calories) {
        this.id = id;
        this.name = name;
        this.summ_calories = summ_calories;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSumm_calories() {
        return summ_calories;
    }

    public void setSumm_calories(Double summ_calories) {
        this.summ_calories = summ_calories;
    }

    public Set<Menu> getMenuSet() {
        return menuSet;
    }

    public void setMenuSet(Set<Menu> menuSet) {
        this.menuSet = menuSet;
    }

    public Set<Ingridients> getIngridSet() {
        return ingridSet;
    }

    public void setIngridSet(Set<Ingridients> ingridSet) {
        this.ingridSet = ingridSet;
    }
}
