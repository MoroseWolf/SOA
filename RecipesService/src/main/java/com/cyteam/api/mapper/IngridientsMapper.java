package com.cyteam.api.mapper;

import com.cyteam.api.dto.IngridientsDTO;
import com.cyteam.api.model.Ingridients;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IngridientsMapper {
    IngridientsDTO toIngridientsDTO(Ingridients ingridients);

    List<IngridientsDTO> toIngridientsDTOs(List<Ingridients> ingridientsList);

    Ingridients toIngridients(IngridientsDTO ingridientsDTO);

}
