package com.cyteam.api.service.Impl;

import com.cyteam.api.dto.IngridientsDTO;
import com.cyteam.api.exceptions.IngridientsNotFoundException;
import com.cyteam.api.mapper.IngridientsMapper;
import com.cyteam.api.model.Ingridients;
import com.cyteam.api.repository.IngridientsRepository;
import com.cyteam.api.service.IngridientsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngridientsServiceImpl implements IngridientsService {

    private final IngridientsRepository ingridientsRepository;
    private final IngridientsMapper ingridientsMapper;

    public IngridientsServiceImpl(IngridientsRepository ingridientsRepository, IngridientsMapper ingridientsMapper) {
        this.ingridientsRepository = ingridientsRepository;
        this.ingridientsMapper = ingridientsMapper;
    }

    @Override
    public void create(IngridientsDTO ingridientsDTO) {
        Ingridients newIngridient = ingridientsMapper.toIngridients(ingridientsDTO);
        ingridientsRepository.save(newIngridient);
    }

    @Override
    public List<IngridientsDTO> readAll() {
        return ingridientsMapper.toIngridientsDTOs(ingridientsRepository.findAll());
    }

    @Override
    public IngridientsDTO read(Long id) {
        return ingridientsMapper.toIngridientsDTO(ingridientsRepository.findById(id)
        .orElseThrow(IngridientsNotFoundException::new));
    }

    @Override
    public boolean update(IngridientsDTO ingridientsDTO, Long id) {
        if (ingridientsRepository.existsById(id)) {
            ingridientsDTO.setId(id);
            ingridientsMapper.toIngridientsDTO(ingridientsRepository.save(ingridientsMapper.toIngridients(ingridientsDTO)));
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (ingridientsRepository.existsById(id)) {
            ingridientsRepository.deleteById(id);
            return  true;
        }
        return false;
    }
}
