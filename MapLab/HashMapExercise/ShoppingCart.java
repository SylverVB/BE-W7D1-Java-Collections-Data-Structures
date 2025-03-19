// Exercise

// Successfully execute a Java program which emulates operations with your shopping cart while shopping at a grocery store.

// You need to use following HashMap Operations:
//   • put: If you want the item, you need to put the item into shopping cart.
//   • get: Once you reach the checkout line, you need to get the items out of your shopping cart for the cashier to tally.
//   • remove: If you don’t want an item in your cart, you need to remove it.

package MapLab.HashMapExercise;

import java.util.HashMap;
import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {
        // Create a shopping cart using HashMap
        HashMap<String, Integer> cart = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the Grocery Store!");
        System.out.println("Commands: ADD <item> <quantity>, REMOVE <item>, GET <item>, CHECKOUT, EXIT");

        while (true) {
            System.out.print("\nEnter your command: ");
            command = scanner.nextLine();
            String[] inputs = command.split(" ");
            
            if (inputs.length == 0) continue;

            switch (inputs[0].toUpperCase()) {
                case "ADD":
                    if (inputs.length != 3) {
                        System.out.println("Invalid command. Use: ADD <item> <quantity>");
                        break;
                    }
                    String itemToAdd = inputs[1];
                    int quantityToAdd;
                    try {
                        quantityToAdd = Integer.parseInt(inputs[2]);
                    } catch (NumberFormatException e) {
                        System.out.println("Quantity must be a number.");
                        break;
                    }
                    cart.put(itemToAdd, cart.getOrDefault(itemToAdd, 0) + quantityToAdd);
                    System.out.println("Added " + quantityToAdd + " of " + itemToAdd + " to the cart.");
                    break;

                case "REMOVE":
                    if (inputs.length != 2) {
                        System.out.println("Invalid command. Use: REMOVE <item>");
                        break;
                    }
                    String itemToRemove = inputs[1];
                    if (cart.remove(itemToRemove) != null) {
                        System.out.println(itemToRemove + " removed from the cart.");
                    } else {
                        System.out.println(itemToRemove + " is not in the cart.");
                    }
                    break;

                case "GET":
                    if (inputs.length != 2) {
                        System.out.println("Invalid command. Use: GET <item>");
                        break;
                    }
                    String itemToGet = inputs[1];
                    System.out.println(itemToGet + " quantity: " + cart.getOrDefault(itemToGet, 0));
                    break;

                case "CHECKOUT":
                    System.out.println("\nItems in your cart:");
                    if (cart.isEmpty()) {
                        System.out.println("Your cart is empty.");
                    } else {
                        for (HashMap.Entry<String, Integer> entry : cart.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
                    }
                    break;

                case "EXIT":
                    System.out.println("Thank you for shopping with us!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Unknown command. Please try again.");
            }
        }
    }
}