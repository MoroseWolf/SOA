package com.cyteam.api.repository;

import com.cyteam.api.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long>  {
}
