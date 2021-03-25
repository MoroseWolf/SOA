package com.cyteam.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menu")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Menu {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "menu_id_seq", sequenceName = "menu_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_id_seq")
    private Long id;

    @NotBlank
    @Column(name = "day")
    private String day;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "summmenu_calories")
    private Integer summ_calories;



    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "menu_recipe",
                joinColumns =  { @JoinColumn(name = "menu_id", referencedColumnName = "id")},
                inverseJoinColumns = { @JoinColumn(name = "recipe_id", referencedColumnName = "id")})
    private Set<Recipe> recipeSet = new HashSet<>();


    public Menu() {
        super();
    }

    public Menu(Long id, String day, String name, Integer summ_calories) {
        super();
        this.id = id;
        this.day = day;
        this.name = name;
        this.summ_calories = summ_calories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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

    public Set<Recipe> getRecipeSet() {
        return recipeSet;
    }
}
