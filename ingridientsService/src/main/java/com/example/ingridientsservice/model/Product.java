package com.example.ingridientsservice.model;

public class Product {

    private Long id;
    private String name;
    private Double carbs;
    private Double fats;
    private Double proteins;
    private Double calories;
    private String article;

    public Product() {
        super();
    }

    public Product(Long id, String name, Double carbs, Double fats, Double proteins, Double calories, String article) {
        super();
        this.id = id;
        this.name = name;
        this.carbs = carbs;
        this.fats = fats;
        this.proteins = proteins;
        this.calories = calories;
        this.article = article;
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

    public Double getCarbs() {
        return carbs;
    }

    public void setCarbs(Double carbs) {
        this.carbs = carbs;
    }

    public Double getFats() {
        return fats;
    }

    public void setFats(Double fats) {
        this.fats = fats;
    }

    public Double getProteins() {
        return proteins;
    }

    public void setProteins(Double proteins) {
        this.proteins = proteins;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
