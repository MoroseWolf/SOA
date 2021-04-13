package com.cyteam.api.controller;

import com.cyteam.api.dto.IngridientsDTO;
import com.cyteam.api.service.IngridientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class IngridientsController {

    private  final IngridientsService ingridientsService;

    @Autowired
    public IngridientsController(IngridientsService ingridientsService) {
        this.ingridientsService = ingridientsService;
    }

    @RequestMapping(
            value = "/ingridients",
            method = POST )
    public ResponseEntity<?> create(@RequestBody IngridientsDTO ingridientsDTO) {
        ingridientsService.create(ingridientsDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/ingridients",
            method = GET )
    public ResponseEntity<List<IngridientsDTO>> read () {
        List<IngridientsDTO> ingridientsList = ingridientsService.readAll();

        return  ingridientsList != null && !ingridientsList.isEmpty()
                ? new ResponseEntity<>(ingridientsList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(
            value = "/ingridients",
            params = "id",
            method = GET)
    public ResponseEntity<IngridientsDTO> read(@RequestParam("id") Long id) {
        IngridientsDTO ingridientsDTO = ingridientsService.read(id);

        return ingridientsDTO != null
                ? new ResponseEntity<>(ingridientsDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(
            value = "/ingridients",
            params = "id",
            method = PUT)
    public ResponseEntity<?> update(@RequestParam("id") Long id, @RequestBody IngridientsDTO ingridientsDTO) {
        final boolean updated = ingridientsService.update(ingridientsDTO, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @RequestMapping(
            value = "/ingridients",
            params = "id",
            method = DELETE)
    public ResponseEntity<?> delete(@RequestParam("id") Long id) {
        final boolean deleted = ingridientsService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


    @RequestMapping(
            value = "/ingridients/allWithCalories",
            method = GET )
    public ResponseEntity<IngridientsDTO[]> readAllWithCalories () {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8081/products";
        IngridientsDTO[] ingridientsDTOArray;

        ResponseEntity<IngridientsDTO[]> response = restTemplate.getForEntity(resourceUrl, IngridientsDTO[].class);

        ingridientsDTOArray = response.getBody();
        return ingridientsDTOArray != null
                ? new ResponseEntity<>(ingridientsDTOArray, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
