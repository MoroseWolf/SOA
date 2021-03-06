package com.cyteam.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Double summ_calories;

    @JsonIgnore
    @ManyToMany(mappedBy = "recipeSet", fetch = FetchType.EAGER)
    private Set<Menu> menuSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "recipe_ingridients",
            joinColumns =  { @JoinColumn(name = "recipe_id", referencedColumnName = "id")},
            inverseJoinColumns = { @JoinColumn(name = "ingrid_id", referencedColumnName = "id")})
    private Set<Ingridients> ingridSet = new HashSet<>();

    public Recipe(){
        super();
    }

    public Recipe(Long id, String name, Double summ_calories) {
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

    public Double getSumm_calories() {
        return summ_calories;
    }

    public void setSumm_calories(Double summ_calories) {
        this.summ_calories = summ_calories;
    }

    public Set<Ingridients> getIngridSet() {
        return ingridSet;
    }

    public void setIngridSet(Set<Ingridients> ingridSet) {
        this.ingridSet = ingridSet;
    }

    public Set<Menu> getMenuSet() {
        return menuSet;
    }

    public void setMenuSet(Set<Menu> menuSet) {
        this.menuSet = menuSet;
    }
}