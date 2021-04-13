package com.cyteam.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class IngridientsDTO {
    private Long id;
    private String name;
    private String article;
    private Double calories;
    @JsonIgnore
    private Set<RecipeDTO> recipesSet = new HashSet<>();

    public IngridientsDTO() {}

    public IngridientsDTO(Long id, String name, String article, Double calories) {
        this.id = id;
        this.name = name;
        this.article = article;
        this.calories = calories;
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

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Set<RecipeDTO> getRecipesSet() {
        return recipesSet;
    }

    public void setRecipesSet(Set<RecipeDTO> recipesSet) {
        this.recipesSet = recipesSet;
    }
}
