import entity.Inventory;
import entity.Order;
import util.MenuForCustomer;
import util.MenuForVendor;
import util.PizzaFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PizzaFactory pizzaFactory = new PizzaFactory();
        List<Order> orders = new ArrayList<>();


        Inventory inventory = new Inventory();
        MenuForCustomer menuForCustomer = new MenuForCustomer();
        MenuForVendor menuForVendor = new MenuForVendor();


        menuForVendor.extracted(scanner, menuForCustomer, menuForVendor);

    }
}
