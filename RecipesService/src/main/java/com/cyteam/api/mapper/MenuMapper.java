package com.cyteam.api.mapper;

import com.cyteam.api.dto.MenuDTO;
import com.cyteam.api.model.Menu;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuMapper {
    MenuDTO toMenuDTO(Menu menu);

    List<MenuDTO> toMenuDTOs(List<Menu> menu);

    Menu toMenu(MenuDTO menuDTO);
}
