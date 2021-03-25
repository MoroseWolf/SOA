package com.cyteam.api.service.Impl;

import com.cyteam.api.model.Recipe;
import com.cyteam.api.repository.RecipeRepository;
import com.cyteam.api.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void create(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> readAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe read(Long id) {
        return recipeRepository.getOne(id);
    }

    @Override
    public boolean update(Recipe recipe, Long id) {
        if(recipeRepository.existsById(id)) {
            recipe.setId(id);
            recipeRepository.save(recipe);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (recipeRepository.existsById(id)){
            recipeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}