package com.cyteam.api.controller;

import com.cyteam.api.model.Menu;
import com.cyteam.api.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> create(@RequestBody Menu menu) {
        menuService.create(menu);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/menu",
            method = GET )
    public ResponseEntity<List<Menu>> read () {
        final List<Menu> menuList = menuService.readAll();

        return  menuList != null && !menuList.isEmpty()
                ? new ResponseEntity<>(menuList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(
            value = "/menu",
            params = "id",
            method = GET)
    public ResponseEntity<Menu> read(@RequestParam("id") Long id) {
        final Menu menu = menuService.read(id);

        return menu != null
                ? new ResponseEntity<>(menu, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(
            value = "/menu",
            params = "id",
            method = PUT)
    public ResponseEntity<?> update(@RequestParam("id") Long id, @RequestBody Menu menu) {
        final boolean updated = menuService.update(menu, id);

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
}