package com.cyteam.api.service.Impl;

import com.cyteam.api.model.Ingridients;
import com.cyteam.api.repository.IngridientsRepository;
import com.cyteam.api.service.IngridientsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngridientsServiceImpl implements IngridientsService {

    private final IngridientsRepository ingridientsRepository;

    public IngridientsServiceImpl(IngridientsRepository ingridientsRepository) {
        this.ingridientsRepository = ingridientsRepository;
    }

    @Override
    public void create(Ingridients ingridients) {
        ingridientsRepository.save(ingridients);
    }

    @Override
    public List<Ingridients> readAll() {
        return ingridientsRepository.findAll();
    }

    @Override
    public Ingridients read(Long id) {
        return ingridientsRepository.getOne(id);
    }

    @Override
    public boolean update(Ingridients ingridients, Long id) {
        if (ingridientsRepository.existsById(id)) {
            ingridients.setId(id);
            ingridientsRepository.save(ingridients);
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
