package com.cyteam.api.service;

import com.cyteam.api.model.Recipe;

import java.util.List;

public interface RecipeService {

    void create(Recipe recipe);

    List<Recipe> readAll();

    Recipe read(Long id);

    boolean update(Recipe recipe, Long id);

    boolean delete(Long id);
}
