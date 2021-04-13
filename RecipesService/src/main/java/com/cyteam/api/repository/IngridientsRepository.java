package com.cyteam.api.repository;

import com.cyteam.api.model.Ingridients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IngridientsRepository extends JpaRepository<Ingridients, Long> {
    Optional<Ingridients> findById(Long id);
}
