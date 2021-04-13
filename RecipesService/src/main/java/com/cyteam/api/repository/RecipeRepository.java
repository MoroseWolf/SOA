package com.cyteam.api.repository;

import com.cyteam.api.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long>  {
    Optional<Recipe> findById(Long id);
}
