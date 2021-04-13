package com.cyteam.api.service.Impl;

import com.cyteam.api.dto.IngridientsDTO;
import com.cyteam.api.dto.MenuDTO;
import com.cyteam.api.exceptions.MenuNotFoundException;
import com.cyteam.api.mapper.IngridientsMapper;
import com.cyteam.api.mapper.MenuMapper;
import com.cyteam.api.model.Ingridients;
import com.cyteam.api.model.Menu;
import com.cyteam.api.model.Recipe;
import com.cyteam.api.repository.MenuRepository;
import com.cyteam.api.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    private final IngridientsMapper ingridientsMapper;

    public MenuServiceImpl(MenuRepository menuRepository, MenuMapper menuMapper, IngridientsMapper ingridientsMapper) {
        this.menuRepository = menuRepository;
        this.menuMapper = menuMapper;
        this.ingridientsMapper = ingridientsMapper;
    }

    @Override
    public void create(MenuDTO menuDTO) {
        Menu newMenu = menuMapper.toMenu(menuDTO);
        menuMapper.toMenuDTO(menuRepository.save(newMenu));
    }

    @Override
    public List<MenuDTO> readAll() {
        List<MenuDTO> menuList = menuMapper.toMenuDTOs(menuRepository.findAll());
        for (MenuDTO oneNote : menuList) {
            summingCalories(oneNote);
        }
        return menuList;
    }

    @Override
    public MenuDTO read(Long id) {
        MenuDTO oneNote = menuMapper.toMenuDTO(menuRepository.findById(id)
                .orElseThrow(MenuNotFoundException::new));
        summingCalories(oneNote);
        return oneNote;
    }

    @Override
    public boolean update(MenuDTO menuDTO, Long id) {
        if (menuRepository.existsById(id)) {
            menuDTO.setId(id);
            menuMapper.toMenuDTO(menuRepository.save(menuMapper.toMenu(menuDTO)));

            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (menuRepository.existsById(id)) {
            menuRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<IngridientsDTO> readMenuIngridients(MenuDTO menuDTO) {
        List<IngridientsDTO> ingridList = new ArrayList<IngridientsDTO>();
        Set<Recipe> recipes = menuDTO.getRecipeSet();
        for(Recipe rec : recipes) {
            List<Ingridients> ingridSet = new ArrayList<Ingridients>(rec.getIngridSet());
            ingridList.addAll(ingridientsMapper.toIngridientsDTOs(ingridSet));
        }
        return ingridList;
    }

    private void summingCalories(MenuDTO menuDTO){
        Set<Recipe> resipeSet = menuDTO.getRecipeSet();
        Set<Ingridients> ingridSet;
        Double calories = 0.0,
                ingridColories;
        for(Recipe recipe : resipeSet){
            ingridSet = recipe.getIngridSet();
            ingridColories = 0.0;
            for (Ingridients ingrid : ingridSet){
                ingridColories += ingrid.getCalories();
            }
            recipe.setSumm_calories(ingridColories);
            calories += ingridColories;
        }
        menuDTO.setSumm_calories(calories);
    }
}