package com.cyteam.api.mapper;

import com.cyteam.api.dto.RecipeDTO;
import com.cyteam.api.model.Recipe;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    RecipeDTO toRecipeDTO(Recipe recipe);

    List<RecipeDTO> toRecipeDTOs(List<Recipe> recipe);

    Recipe toRecipe(RecipeDTO recipeDTO);
}
