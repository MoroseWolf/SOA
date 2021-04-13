package com.cyteam.api.service;

import com.cyteam.api.dto.IngridientsDTO;
import com.cyteam.api.model.Ingridients;

import java.util.List;

public interface IngridientsService {

    void create(IngridientsDTO ingridientsDTO);

    List<IngridientsDTO> readAll();

    IngridientsDTO read(Long id);

    boolean update(IngridientsDTO ingridientsDTO, Long id);

    boolean delete(Long id);
}
