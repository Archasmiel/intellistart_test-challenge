import objects.TradeSystem;

import java.util.Arrays;
import java.util.Scanner;

import static lib.Output.*;

public class Main {

    private static final TradeSystem system = new TradeSystem();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command;
        boolean working = true;

        while (working) {
            System.out.print("Enter command: ");
            command = scanner.nextLine();
            try {
                switch (command) {
                    case "stop" -> working = false;

                    case "show users" -> printUsers(system);
                    case "show products" -> printProducts(system);
                    case "show user products" -> printUserProducts(scanner, system);

                    case "add user" -> addUser(scanner, system);
                    case "add product" -> addProduct(scanner, system);

                    case "buy product" -> buyProduct(scanner, system);
                    default -> throw new IllegalStateException("Unexpected command: " + command);
                }
            } catch (Exception e) {
                System.out.println("EXCEPTION:\n" + e);
                System.out.println(Arrays.toString(e.getStackTrace()));
            }

            System.out.print("\n\n\n");

        }

        scanner.close();

    }



}
