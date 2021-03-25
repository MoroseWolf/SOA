package com.cyteam.api.controller;

import com.cyteam.api.model.Ingridients;
import com.cyteam.api.service.IngridientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> create(@RequestBody Ingridients ingridients) {
        ingridientsService.create(ingridients);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/ingridients",
            method = GET )
    public ResponseEntity<List<Ingridients>> read () {
        final List<Ingridients> ingridientsList = ingridientsService.readAll();

        return  ingridientsList != null && !ingridientsList.isEmpty()
                ? new ResponseEntity<>(ingridientsList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(
            value = "/ingridients",
            params = "id",
            method = GET)
    public ResponseEntity<Ingridients> read(@RequestParam("id") Long id) {
        final Ingridients ingridients = ingridientsService.read(id);

        return ingridients != null
                ? new ResponseEntity<>(ingridients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(
            value = "/ingridients",
            params = "id",
            method = PUT)
    public ResponseEntity<?> update(@RequestParam("id") Long id, @RequestBody Ingridients ingridients) {
        final boolean updated = ingridientsService.update(ingridients, id);

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
}
