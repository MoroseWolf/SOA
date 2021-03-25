package com.cyteam.api.controller;

import com.cyteam.api.model.Recipe;
import com.cyteam.api.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(
            value = "/recipe",
            method = POST )
    public ResponseEntity<?> create(@RequestBody Recipe recipe) {
        recipeService.create(recipe);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/recipe",
            method = GET )
    public ResponseEntity<List<Recipe>> read() {
        final List<Recipe> recipeList = recipeService.readAll();

        return recipeList != null && !recipeList.isEmpty()
                ? new ResponseEntity<>(recipeList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @RequestMapping(
            value = "/recipe",
            params = "id",
            method = GET)
    public ResponseEntity<Recipe> read(@RequestParam("id") Long id) {
        final Recipe recipe = recipeService.read(id);

        return recipe != null
                ? new ResponseEntity<>(recipe, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(
            value = "/recipe",
            params = "id",
            method = PUT)
    public ResponseEntity<?> update(@RequestParam("id") Long id, @RequestBody Recipe recipe) {
        final boolean updated = recipeService.update(recipe, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @RequestMapping(
            value = "/recipe",
            params = "id",
            method = DELETE)
    public ResponseEntity<?> delete(@RequestParam("id") Long id) {
        final boolean deleted = recipeService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}