package entity;

import util.Category;

import java.util.List;

public class Pizza {
    private int pizzaId;
    private String pizzaName;
    private boolean isVegetarian;
    private List<Category> category;

    public Pizza() {
    }

    public Pizza(int pizzaId, String pizzaName, boolean isVegetarian, List<Category> category) {
        this.pizzaId = pizzaId;
        this.pizzaName = pizzaName;
        this.isVegetarian = isVegetarian;
        this.category = category;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }
}
