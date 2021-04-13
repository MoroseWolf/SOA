package com.cyteam.api.service.Impl;

import com.cyteam.api.dto.RecipeDTO;
import com.cyteam.api.exceptions.RecipeNotFoundException;
import com.cyteam.api.mapper.IngridientsMapper;
import com.cyteam.api.mapper.RecipeMapper;
import com.cyteam.api.model.Ingridients;
import com.cyteam.api.model.Recipe;
import com.cyteam.api.repository.RecipeRepository;
import com.cyteam.api.service.RecipeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;
    private final IngridientsMapper ingridientsMapper;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeMapper recipeMapper, IngridientsMapper ingridientsMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
        this.ingridientsMapper = ingridientsMapper;
    }

    @Override
    public void create(RecipeDTO recipeDTO) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDTO.getName());
        recipe.setSumm_calories(0.0);
        for (Ingridients ingrid : recipeDTO.getIngridSet()) {
            ingrid.setId(null);
        }
        recipe.setIngridSet(recipeDTO.getIngridSet());
        recipeRepository.save(recipe);
    }

    @Override
    public List<RecipeDTO> readAll() {
        List<RecipeDTO> recipeList = recipeMapper.toRecipeDTOs(recipeRepository.findAll());
        for (RecipeDTO rec : recipeList) {
            summingCalories(rec);
        }
        return recipeList;
    }

    @Override
    public RecipeDTO read(Long id) {
        RecipeDTO oneNote = recipeMapper.toRecipeDTO(recipeRepository.findById(id)
                .orElseThrow(RecipeNotFoundException::new));
        summingCalories(oneNote);
        return oneNote;
    }

    @Override
    public boolean update(RecipeDTO recipe, Long id) {
        if(recipeRepository.existsById(id)) {
            recipe.setId(id);
            recipeMapper.toRecipeDTO(recipeRepository.save(recipeMapper.toRecipe(recipe)));
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

    @Override
    public void createToMenu(RecipeDTO recipeDTO, Long id){
        Recipe newRecipe = recipeMapper.toRecipe(recipeDTO);
        recipeRepository.save(newRecipe);
    }

    private void summingCalories(RecipeDTO recipeDTO){
        Set<Ingridients> ingridSet = recipeDTO.getIngridSet();
        Double calories = 0.0;
        for(Ingridients ingrid : ingridSet){
            calories += ingrid.getCalories();
        }
        recipeDTO.setSumm_calories(calories);
    }
}