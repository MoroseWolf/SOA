package com.cyteam.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recipe")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Recipe {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "recipe_id_seq", sequenceName = "recipe_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_id_seq")
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "summrecipe_calories")
    private Integer summ_calories;

    @ManyToMany(mappedBy = "recipeSet", fetch = FetchType.LAZY)
    private Set<Menu> menuSet = new HashSet<>();

    public Recipe(){
        super();
    }

    public Recipe(Long id, String name, Integer summ_calories) {
        super();
        this.id = id;
        this.name = name;
        this.summ_calories = summ_calories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSumm_calories() {
        return summ_calories;
    }

    public void setSumm_calories(Integer summ_calories) {
        this.summ_calories = summ_calories;
    }
}
