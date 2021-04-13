package com.cyteam.api.dto;

import com.cyteam.api.model.Recipe;

import java.util.HashSet;
import java.util.Set;


public class MenuDTO {
    private Long id;
    private String day;
    private String name;
    private Double summ_calories;
    private Set<Recipe> recipeSet = new HashSet<>();

    public MenuDTO() {
    }

    public MenuDTO(Long id, String day, String name, Double summ_calories ) {
        this.id = id;
        this.day = day;
        this.name = name;
        this.summ_calories = summ_calories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Recipe> getRecipeSet() {
        return recipeSet;
    }

    public void setRecipeSet(Set<Recipe> recipeSet) {
        this.recipeSet = recipeSet;
    }

    public Double getSumm_calories() {
        return summ_calories;
    }

    public void setSumm_calories(Double summ_calories) {
        this.summ_calories = summ_calories;
    }
}
