import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Copyright (c) 2025, WONG Sai Lung. All rights reserved.
 * @author WONG, Sai Lung
 * @version v1.0.1
 */
public class Input {

    /**
     * Get a valid integer input from the user.
     *
     * @param scanner      The Scanner object to read input
     * @param prompt       The prompt message to display
     * @param errorMessage The error message to display for invalid input
     * @return The valid integer input
     */
    public static int getInput(Scanner scanner, String prompt, String errorMessage) {
        int input;
        while (true) {
            System.out.print(prompt);
            try {
                input = scanner.nextInt();
                if (input < 0) {
                    throw new IllegalArgumentException(errorMessage);
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a valid integer.");
                scanner.nextLine(); // Clear the invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }
}
