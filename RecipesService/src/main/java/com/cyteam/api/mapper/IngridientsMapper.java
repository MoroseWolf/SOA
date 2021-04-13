package com.cyteam.api.mapper;

import com.cyteam.api.dto.IngridientsDTO;
import com.cyteam.api.model.Ingridients;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface IngridientsMapper {
    IngridientsDTO toIngridientsDTO(Ingridients ingridients);

    List<IngridientsDTO> toIngridientsDTOs(List<Ingridients> ingridientsList);

    Ingridients toIngridients(IngridientsDTO ingridientsDTO);

    Set<Ingridients> toIngridientss(Collection<IngridientsDTO> ingridientsDTOList);

}
