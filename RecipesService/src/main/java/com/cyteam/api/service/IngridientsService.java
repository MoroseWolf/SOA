package com.cyteam.api.service;

import com.cyteam.api.model.Ingridients;

import java.util.List;

public interface IngridientsService {

    void create(Ingridients ingridients);

    List<Ingridients> readAll();

    Ingridients read(Long id);

    boolean update(Ingridients ingridients, Long id);

    boolean delete(Long id);
}
