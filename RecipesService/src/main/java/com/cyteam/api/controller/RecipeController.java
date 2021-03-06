package com.cyteam.api.controller;

import com.cyteam.api.dto.RecipeDTO;
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
    public ResponseEntity<?> create(@RequestBody RecipeDTO recipeDTO) {
        recipeService.create(recipeDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/recipe",
            method = GET )
    public ResponseEntity<List<RecipeDTO>> read() {
        final List<RecipeDTO> recipeList = recipeService.readAll();

        return recipeList != null && !recipeList.isEmpty()
                ? new ResponseEntity<>(recipeList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @RequestMapping(
            value = "/recipe",
            params = "id",
            method = GET)
    public ResponseEntity<RecipeDTO> read(@RequestParam("id") Long id) {
        final RecipeDTO recipeDTO = recipeService.read(id);

        return recipeDTO != null
                ? new ResponseEntity<>(recipeDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(
            value = "/recipe",
            params = "id",
            method = PUT)
    public ResponseEntity<?> update(@RequestParam("id") Long id, @RequestBody RecipeDTO recipeDTO) {
        final boolean updated = recipeService.update(recipeDTO, id);

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