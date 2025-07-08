import java.util.Scanner;

public class PizzaBillGenerator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pizza price constants
        final int VEG_PIZZA_PRICE = 200;
        final int NON_VEG_PIZZA_PRICE = 300;
        final int DELUX_VEG_PIZZA_PRICE = 350;
        final int DELUX_NON_VEG_PIZZA_PRICE = 450;
        final int EXTRA_CHEESE_PRICE = 50;
        final int EXTRA_TOPPINGS_PRICE = 75;
        final int PACKAGING_CHARGES = 30;

        int totalAmount = 0;

        System.out.println("Welcome to Pizzamania!");
        System.out.println("Select Pizza Type:");
        System.out.println("1. Veg Pizza");
        System.out.println("2. Non-Veg Pizza");
        System.out.println("3. Deluxe Veg Pizza (With extra cheese & toppings already loaded)");
        System.out.println("4. Deluxe Non-Veg Pizza (With extra cheese & toppings already loaded)");

        int pizzaChoice = sc.nextInt();
        boolean deluxePizza = false;

        switch (pizzaChoice) {
            case 1:
                totalAmount = VEG_PIZZA_PRICE;
                break;
            case 2:
                totalAmount = NON_VEG_PIZZA_PRICE;
                break;
            case 3:
                totalAmount = DELUX_VEG_PIZZA_PRICE;
                deluxePizza = true;
                break;
            case 4:
                totalAmount = DELUX_NON_VEG_PIZZA_PRICE;
                deluxePizza = true;
                break;
            default:
                System.out.println("Invalid selection. Exiting.");
                return;
        }

        // Asking for extra cheese and extra toppings if not deluxe
        if (!deluxePizza) {
            System.out.println("Do you want Extra Cheese? (Yes/No)");
            String cheeseChoice = sc.next();
            if (cheeseChoice.equalsIgnoreCase("Yes")) {
                totalAmount += EXTRA_CHEESE_PRICE;
            }

            System.out.println("Do you want Extra Toppings? (Yes/No)");
            String toppingsChoice = sc.next();
            if (toppingsChoice.equalsIgnoreCase("Yes")) {
                totalAmount += EXTRA_TOPPINGS_PRICE;
            }
        }

        // Asking if the customer wants take away
        System.out.println("Do you want take away? (Yes/No)");
        String takeAwayChoice = sc.next();
        if (takeAwayChoice.equalsIgnoreCase("Yes")) {
            totalAmount += PACKAGING_CHARGES;
        }

        // Displaying the final bill
        System.out.println("---------- Pizzamania Bill ----------");
        System.out.println("Total Amount: Rs. " + totalAmount);
        System.out.println("Thank you for choosing Pizzamania!");
        sc.close();
    }
}

