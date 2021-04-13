package com.cyteam.api.service;

import com.cyteam.api.dto.RecipeDTO;

import java.util.List;

public interface RecipeService {

    void create(RecipeDTO recipeDTO);

    List<RecipeDTO> readAll();

    RecipeDTO read(Long id);

    boolean update(RecipeDTO recipeDTO, Long id);

    boolean delete(Long id);

    void createToMenu(RecipeDTO recipeDTO, Long id);
}
