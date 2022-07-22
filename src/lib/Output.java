package lib;

import objects.TradeSystem;

import java.util.Scanner;

/**
 * Additional output class<br>
 * Used to shorten Main class switch state and separate methods
 */
public class Output {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static final String helpString =
            ANSI_GREEN + "              [h/help]: " + ANSI_RESET + "Print this help.\n" +
            ANSI_GREEN + "              [e/exit]: " + ANSI_RESET + "Close system.\n" +
            ANSI_GREEN + "        [1/show users]: " + ANSI_RESET + "Show all users in system.\n" +
            ANSI_GREEN + "     [2/show products]: " + ANSI_RESET + "Show all products in system.\n" +
            ANSI_GREEN + "[3/show user products]: " + ANSI_RESET + "Show products bought by user.\n" +
            ANSI_GREEN + "[4/show product users]: " + ANSI_RESET + "Show users bought specified product.\n" +
            ANSI_GREEN + "          [5/add user]: " + ANSI_RESET + "Add user to system.\n" +
            ANSI_GREEN + "       [6/add product]: " + ANSI_RESET + "Add product to system.\n" +
            ANSI_GREEN + "       [7/remove user]: " + ANSI_RESET + "Remove user from system and purchases list.\n" +
            ANSI_GREEN + "    [8/remove product]: " + ANSI_RESET + "Remove product from system and user purchases.\n" +
            ANSI_GREEN + "       [9/buy product]: " + ANSI_RESET + "Buy specified product by specified user.";

    public static void printHelp() {
        System.out.println(helpString);
    }

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

    public static void printProductUsers(Scanner scanner, TradeSystem system) {
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
        System.out.println(system.getProductUsers(id));
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




    public static void removeProduct(Scanner scanner, TradeSystem system) {
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
        system.removeProduct(id);
    }

    public static void removeUser(Scanner scanner, TradeSystem system) {
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
        system.removeUser(id);
    }





    public static void buyProduct(Scanner scanner, TradeSystem system) {
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter product ID: ");
        String productId = scanner.nextLine();
        system.buyProduct(userId, productId);
    }

}
