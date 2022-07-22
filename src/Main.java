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
        printHelp();

        while (working) {
            System.out.print(ANSI_PURPLE + "Enter command: " + ANSI_RESET);
            command = scanner.nextLine();
            if (command.equals("h") || command.equals("help")) System.out.print("\n\n\n");
            try {
                switch (command) {
                    case "help", "h" -> printHelp();
                    case "stop", "e" -> working = false;

                    case "show users", "1" -> printUsers(system);
                    case "show products", "2" -> printProducts(system);
                    case "show user products", "3" -> printUserProducts(scanner, system);
                    case "show product users", "4" -> printProductUsers(scanner, system);

                    case "add user", "5" -> addUser(scanner, system);
                    case "add product", "6" -> addProduct(scanner, system);

                    case "remove user", "7" -> removeUser(scanner, system);
                    case "remove product", "8" -> removeProduct(scanner, system);

                    case "buy product", "9" -> buyProduct(scanner, system);
                    default -> throw new IllegalStateException("Unexpected command: '" + command + "'");
                }

                if (!command.equals("h") && !command.equals("help"))System.out.print("\n\n\n");
            } catch (Exception e) {
                System.out.println("EXCEPTION:\n" + e);
                System.out.println(Arrays.toString(e.getStackTrace()));
                System.out.print("\n\n\n");
            }



        }

        scanner.close();

    }




}
