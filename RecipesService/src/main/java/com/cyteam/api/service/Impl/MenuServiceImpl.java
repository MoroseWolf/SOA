package com.cyteam.api.service.Impl;

import com.cyteam.api.model.Menu;
import com.cyteam.api.model.Recipe;
import com.cyteam.api.repository.MenuRepository;
import com.cyteam.api.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public void create(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    public List<Menu> readAll() {
        List<Menu> menuList = menuRepository.findAll();
        for (Menu oneNote : menuList) {
            summingCalories(oneNote);
        }
        return menuList;
    }

    @Override
    public Menu read(Long id) {
        Menu oneNote = menuRepository.getOne(id);
        summingCalories(oneNote);
        return oneNote;
    }

    @Override
    public boolean update(Menu menu, Long id) {
        if (menuRepository.existsById(id)) {
            menu.setId(id);
            menuRepository.save(menu);
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

    private void summingCalories(Menu menu){
        Set<Recipe> resipeSet = menu.getRecipeSet();
        Integer calories = 0;
        for(Recipe recipe : resipeSet){
            calories += recipe.getSumm_calories();
        }
        menu.setSumm_calories(calories);
    }
}