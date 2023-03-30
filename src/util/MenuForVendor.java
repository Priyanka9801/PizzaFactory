package util;

import entity.Pizza;
import enums.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuForVendor {

    public void extracted(Scanner scanner, MenuForCustomer menuForCustomer, MenuForVendor menuForVendor) {
        int choice;
        while (true) {
            System.out.println("Press 1 for Customer");
            System.out.println("Press 2 for Vendor");
            System.out.println("Press 3 to Quit\n ");
            System.out.println("Make your choice");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    menuForCustomer.runForCustomer(scanner, menuForCustomer, menuForVendor);
                    break;
                case 2:
                    menuForVendor.runForVendor(scanner, menuForCustomer, menuForVendor);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!!! Please make a valid choice. \\n\\n");
            }
        }
    }

    public void runForVendor(Scanner scanner, MenuForCustomer menuForCustomer, MenuForVendor menuForVendor) {
        int choice;
        while (true) {
            System.out.println("Press 1 for add a Pizza");
            System.out.println("Press 2 for add a Crust");
            System.out.println("Press 3 for Add a Topping");
            System.out.println("Press 4 for return to main menu");
            System.out.println("Press 5 to Quit\n \n ");
            System.out.println("Make your choice");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Pizza pizza = new Pizza();
                    System.out.println("Enter the name of Pizza ");
                    pizza.setPizzaName(scanner.next());
                    System.out.println("Enter the 1 if Pizza is Vegetarian or enter 0 ");
                    pizza.setVegetarian(scanner.nextBoolean());
                    List<Category> categories = new ArrayList<>();
                    int length = Size.values().length;
                    int ordinal = 0;
                    while (length > 0) {
                        Category category = new Category();
                        category.setSize(Size.values()[ordinal++]);
                        System.out.println("Enter the amount of the " + Size.valueOf(category.getSize().toString()) + " pizza = ");
                        category.setAmount(scanner.nextDouble());
                        categories.add(category);
                        --length;
                    }

                    break;
                case 2:
                    break;
                case 3:
                    System.exit(0);
                case 4:
                    extracted(scanner, menuForCustomer, menuForVendor);
                default:
                    System.out.println("Invalid choice!!! Please make a valid choice. \\n\\n");
            }
        }
    }
}
