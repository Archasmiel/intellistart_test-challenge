package lib;

import objects.TradeSystem;

import java.util.Scanner;

public class Output {

    public static void printUsers(TradeSystem system) {
        System.out.println(system.getUsers());
    }

    public static void printProducts(TradeSystem system) {
        System.out.println(system.getProducts());
    }

    public static void printUserProducts(Scanner scanner, TradeSystem system) {
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
        System.out.println(system.getUserProducts(id));
    }

    public static void addProduct(Scanner scanner, TradeSystem system) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        float price = Float.parseFloat(scanner.nextLine());
        system.addProduct(name, price);
    }

    public static void addUser(Scanner scanner, TradeSystem system) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter money: ");
        float money = Float.parseFloat(scanner.nextLine());
        system.addUser(name, lastName, money);
    }

    public static void buyProduct(Scanner scanner, TradeSystem system) {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter product ID: ");
        String productId = scanner.nextLine();
        system.buyProduct(userId, productId);
    }

}
