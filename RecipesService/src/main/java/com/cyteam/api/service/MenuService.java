package com.cyteam.api.service;

import com.cyteam.api.model.Menu;

import java.util.List;

public interface MenuService {

    void create(Menu menu);

    List<Menu> readAll();

    Menu read(Long id);

    boolean update(Menu menu, Long id);

    boolean delete(Long id);
}
