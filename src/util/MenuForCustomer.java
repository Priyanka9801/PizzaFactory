package util;

import entity.*;
import enums.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MenuForCustomer {

    List<Order> orders = new ArrayList<>();
    Inventory inventory = new Inventory();
    double grossAmount = 0;

    public void runForCustomer(Scanner scanner, MenuForCustomer menuForCustomer, MenuForVendor menuForVendor, PizzaFactory pizzaFactory) {
        int choice;
        while (true) {
            System.out.println("Press 1 for Order a pizza");
            System.out.println("Press 2 for go to the main menu");
            System.out.println("Press 2 to Quit\n \n ");
            System.out.println("Make your choice");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printPizzas(pizzaFactory);
                    orderPizza(scanner, pizzaFactory);
                    printInvoice(pizzaFactory);
                    break;
                case 2:
                    menuForVendor.extracted(scanner, menuForCustomer, menuForVendor, pizzaFactory);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!!! Please make a valid choice. \\n\\n");
            }
        }
    }

    private void printInvoice(PizzaFactory pizzaFactory) {

        System.out.println("\n------------------------INVOICE RECEIPT---------------------------");
        System.out.println("     Item             Category              Amount    ");
        for (Order order : orders) accept(order, pizzaFactory);
        System.out.println("                       GROSS AMOUNT TO PAY = " + grossAmount);
        System.out.println("------------------------------------------------------------------\n");
    }

    private void orderPizza(Scanner scanner, PizzaFactory pizzaFactory) {

        int pizzaId = getPizzaId(scanner, pizzaFactory);
        int categoryId = getCategoryId(scanner, pizzaId, pizzaFactory);
        int crustId = getCrustId(scanner);
        int toppingId = getToppingId(scanner, pizzaId, pizzaFactory);
        String cheese = getString(scanner);
        int sideId = getSideId(scanner, pizzaFactory);
        Order order = new Order(pizzaId, categoryId, crustId, toppingId, cheese.equalsIgnoreCase("y"), sideId);
        orders.add(order);
    }

    private int getSideId(Scanner scanner, PizzaFactory pizzaFactory) {
        System.out.println("\nWould you like to add any Sides ");
        System.out.println("SR NO            NAME                     AMOUNT");
        pizzaFactory.getSides()
                .forEach(e -> System.out.println(e.getSideId() + "          " + e.getSideName() + "      price =" + e.getSidePrice()));
        int sideId = scanner.nextInt();
        List<Integer> integers = pizzaFactory.getSides().stream().map(Side::getSideId).toList();
        while (!integers.contains(sideId)) {
            System.out.println("Invalid entry inputted");
            sideId = scanner.nextInt();
        }
        return sideId;
    }

    private String getString(Scanner scanner) {
        System.out.println("\nWould you like to have a Extra Cheese");
        inventory.getCheese().forEach((key, value) -> System.out.println(key + "   " + value));
        System.out.println("Press Y/N");
        String cheese = scanner.next();
        while (!cheese.equalsIgnoreCase("Y") && !cheese.equalsIgnoreCase("N")) {
            System.out.println("Invalid entry inputted");
            cheese = scanner.next();
        }
        return cheese;
    }

    private int getCrustId(Scanner scanner) {
        System.out.println("\nEnter any  Crust over pizza");
        inventory.getCrust().forEach(
                e -> System.out.println(inventory.getCrust().indexOf(e) + 1 + "   " + e));
        int size = inventory.getCrust().size();
        int crustId = scanner.nextInt();
        while (crustId <= 0 || crustId > size) {
            System.out.println("Invalid entry inputted");
            crustId = scanner.nextInt();
        }
        return crustId;
    }

    private int getPizzaId(Scanner scanner, PizzaFactory pizzaFactory) {
        System.out.println("\nEnter the number which you have to order");
        List<Integer> collect = pizzaFactory.getPizzas().stream()
                .map(Pizza::getPizzaId)
                .toList();
        int pizzaId = scanner.nextInt();
        while (!collect.contains(pizzaId)) {
            System.out.println("Invalid entry inputted");
            pizzaId = scanner.nextInt();
        }
        return pizzaId;
    }

    private int getToppingId(Scanner scanner, int pizzaId, PizzaFactory pizzaFactory) {
        System.out.println("\nEnter any topping over Pizza");
        System.out.println("SR NO            NAME                     AMOUNT");
        List<Topping> toppings = pizzaFactory.getToppings().stream()
                .filter(e -> e.isVeg() == pizzaFactory.getPizzas().stream()
                        .filter(pizza -> pizza.getPizzaId() == pizzaId)
                        .findFirst()
                        .get()
                        .isVegetarian()).toList();
        toppings.forEach(e -> System.out.println(e.getToppingId() + "          " + e.getToppingName() + "      price =" + e.getToppingPrice()));

        List<Integer> integers = toppings.stream()
                .map(Topping::getToppingId)
                .toList();

        int toppingId = scanner.nextInt();
        while (!integers.contains(toppingId)) {
            System.out.println("Invalid entry inputted");
            toppingId = scanner.nextInt();
        }
        return toppingId;
    }

    private int getCategoryId(Scanner scanner, int pizzaId, PizzaFactory pizzaFactory) {
        System.out.println("\nEnter any Category");
        System.out.println("SR NO     NAME       AMOUNT");
        pizzaFactory.getPizzas().stream()
                .filter(pizza -> pizza.getPizzaId() == pizzaId)
                .forEach(e -> e.getCategory()
                        .forEach(category -> System.out.println(Size.valueOf(category.getSize().toString()).ordinal() + 1 +
                                "    " + category.getSize() + "     " + category.getAmount())));
        int categoryId = scanner.nextInt();
        while (Size.values().length < categoryId || categoryId <= 0) {
            System.out.println("Invalid entry inputted");
            categoryId = scanner.nextInt();
        }
        return categoryId;
    }

    private void printPizzas(PizzaFactory pizzaFactory) {
        System.out.println("\n-----------------------------------PIZZA ORDERING SERVICE--------------------------------------");
        System.out.println("Menus for Pizza : ");
        System.out.println("ITEM NO               NAME                     AMOUNT");
        System.out.println("Vegetarian :");
        pizzaFactory.getPizzas().stream()
                .filter(Pizza::isVegetarian)
                .forEach(e -> System.out.println(e.getPizzaId() + "          " + e.getPizzaName() + "      price =" + e.getCategory()));
        System.out.println("Non-Vegetarian :");
        pizzaFactory.getPizzas().stream()
                .filter(e -> !e.isVegetarian())
                .forEach(e -> System.out.println(e.getPizzaId() + "          " + e.getPizzaName() + "      price =" + e.getCategory()));
    }

    private void accept(Order order, PizzaFactory pizzaFactory
    ) {
        Pizza pizza1 = pizzaFactory.getPizzas().stream()
                .filter(pizza -> pizza.getPizzaId() == order.getPizzaId())
                .findFirst()
                .get();
        String pizzaName = pizza1.getPizzaName();
        List<Category> category = pizza1.getCategory();
        Size size = category.stream()
                .filter(category1 -> category1.getSize().ordinal() == order.getPizzaCategory() - 1)
                .findFirst()
                .get()
                .getSize();
        double amount = category.stream()
                .filter(category1 -> category1.getSize().ordinal() == order.getPizzaCategory() - 1)
                .findFirst()
                .get()
                .getAmount();
        String crust = inventory.getCrust().stream()
                .filter(e -> inventory.getCrust().indexOf(e) == order.getCrustId() - 1)
                .findFirst()
                .get();
        Topping topping = pizzaFactory.getToppings().stream()
                .filter(e -> e.getToppingId() == order.getCrustId())
                .findFirst()
                .get();
        String toppingName = topping.getToppingName();
        double toppingAmount = topping.getToppingPrice();
        Side side = pizzaFactory.getSides().stream()
                .filter(e -> e.getSideId() == order.getSideId())
                .findFirst()
                .get();
        String sideName = side.getSideName();
        double sideAmount = side.getSidePrice();
        double cheeseAmount = inventory.getCheese().get("Cheese");
        grossAmount = grossAmount + amount + toppingAmount + cheeseAmount + sideAmount;

        System.out.println(" " + pizzaName + "       " + size + "-PIZZA        " + amount);
        System.out.println(" " + crust + "        CRUST               free");
        System.out.println(" " + toppingName + "             TOPPING            " + toppingAmount);
        if (order.isCheeseApply()) System.out.println(" Cheese                  CHEESE        " + cheeseAmount);
        System.out.println(" " + sideName + "           SIDE              " + sideAmount);
    }
}
