package com.cyteam.api.controller;

import com.cyteam.api.dto.IngridientsDTO;
import com.cyteam.api.dto.MenuDTO;
import com.cyteam.api.dto.RecipeDTO;
import com.cyteam.api.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @RequestMapping(
            value = "/menu",
            method = POST )
    public ResponseEntity<?> create(@RequestBody MenuDTO menuDTO) {
        menuService.create(menuDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/menu",
            method = GET )
    public ResponseEntity<List<MenuDTO>> read () {
        final List<MenuDTO> menuList = menuService.readAll();

        return  menuList != null && !menuList.isEmpty()
                ? new ResponseEntity<>(menuList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(
            value = "/menu",
            params = "id",
            method = GET)
    public ResponseEntity<MenuDTO> read(@RequestParam("id") Long id) {
        final MenuDTO menuDTO = menuService.read(id);

        return menuDTO != null
                ? new ResponseEntity<>(menuDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(
            value = "/menu",
            params = "id",
            method = PUT)
    public ResponseEntity<?> update(@RequestParam("id") Long id, @RequestBody MenuDTO menuDTO) {
        final boolean updated = menuService.update(menuDTO, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @RequestMapping(
            value = "/menu",
            params = "id",
            method = DELETE)
    public ResponseEntity<?> delete(@RequestParam("id") Long id) {
        final boolean deleted = menuService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @RequestMapping(
            value = "/menu/buy",
            params = "id",
            method = POST )
    public ResponseEntity<List<IngridientsDTO>>buyIngridients(@RequestParam("id") Long id) {
        MenuDTO menuDTO = menuService.read(id);
        List<IngridientsDTO> ingridList = menuService.readMenuIngridients(menuDTO);

        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://192.168.43.26:9075/api/Ingredients";


        ResponseEntity<IngridientsDTO[]> response = restTemplate.getForEntity(resourceUrl, IngridientsDTO[].class);
        IngridientsDTO[] ingrids = response.getBody();
        return  ingrids != null && !ingridList.isEmpty()
                ? new ResponseEntity<>(ingridList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}