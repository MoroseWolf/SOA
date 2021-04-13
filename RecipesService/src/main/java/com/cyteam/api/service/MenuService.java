package com.cyteam.api.service;

import com.cyteam.api.dto.IngridientsDTO;
import com.cyteam.api.dto.MenuDTO;

import java.util.List;

public interface MenuService {

    void create(MenuDTO menuDTO);

    List<MenuDTO> readAll();

    MenuDTO read(Long id);

    boolean update(MenuDTO menuDTO, Long id);

    boolean delete(Long id);

    List<IngridientsDTO> readMenuIngridients(MenuDTO menuDTO);
}
