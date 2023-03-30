package util;

import entity.Pizza;
import entity.Side;
import entity.Topping;
import enums.Size;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PizzaFactory {
    private List<Pizza> pizzas = new ArrayList<>();
    private List<Topping> toppings = new ArrayList<>();
    private List<Side> sides = new ArrayList<>();

    {
        pizzas.add(new Pizza(1, "Deluxe Veggie", true, Arrays.asList(new Category(Size.REGULAR, 150),
                new Category(Size.MEDIUM, 200), new Category(Size.LARGE, 325))));
        pizzas.add(new Pizza(2, "Cheese and corn", true, Arrays.asList(new Category(Size.REGULAR, 175),
                new Category(Size.MEDIUM, 375), new Category(Size.LARGE, 475))));
        pizzas.add(new Pizza(3, "Paneer Tikka", true, Arrays.asList(new Category(Size.REGULAR, 160),
                new Category(Size.MEDIUM, 290), new Category(Size.LARGE, 340))));
        pizzas.add(new Pizza(4, "Non-Veg Supreme", false, Arrays.asList(new Category(Size.REGULAR, 190),
                new Category(Size.MEDIUM, 325), new Category(Size.LARGE, 425))));
        pizzas.add(new Pizza(5, "Chicken Tikka", false, Arrays.asList(new Category(Size.REGULAR, 210),
                new Category(Size.MEDIUM, 370), new Category(Size.LARGE, 500))));
        pizzas.add(new Pizza(6, "Pepper Barbecue Chicken", false, Arrays.asList(new Category(Size.REGULAR, 220),
                new Category(Size.MEDIUM, 380), new Category(Size.LARGE, 525))));
        toppings.add(new Topping(1, "Black olive", true, 20));
        toppings.add(new Topping(2, "Capsicum", true, 25));
        toppings.add(new Topping(3, "Paneer", true, 35));
        toppings.add(new Topping(4, "Mushroom", true, 30));
        toppings.add(new Topping(5, "Fresh tomato", true, 10));

        toppings.add(new Topping(3, "Chicken tikka", false, 35));
        toppings.add(new Topping(4, "Barbeque chicken", false, 45));
        toppings.add(new Topping(5, "Grilled chicken", false, 40));

        sides.add(new Side(1, "Cold drink", 55));
        sides.add(new Side(2, "Mousse cake", 90));

    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public List<Side> getSides() {
        return sides;
    }

    public void setSides(List<Side> sides) {
        this.sides = sides;
    }
}
