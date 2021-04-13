package com.cyteam.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="ingridients")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ingridients {

    @Id
    @Column(name="id")
    @SequenceGenerator(name = "ingridients_id_seq", sequenceName = "ingridients_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =  "ingridients_id_seq")
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "article")
    private String article;

    @NotBlank
    @Column(name = "calories")
    private Double calories;

    @JsonIgnore
    @ManyToMany(mappedBy = "ingridSet", fetch = FetchType.EAGER)
    private Set<Recipe> recipesSet = new HashSet<>();

    public Ingridients(){ super();}

    public Ingridients(Long id, @NotBlank String name, @NotBlank String article, @NotBlank Double calories) {
        super();
        this.id = id;
        this.name = name;
        this.article = article;
        this.calories = calories;
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

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Set<Recipe> getRecipesSet() {
        return recipesSet;
    }

    public void setRecipesSet(Set<Recipe> recipesSet) {
        this.recipesSet = recipesSet;
    }
}
