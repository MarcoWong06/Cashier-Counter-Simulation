import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Copyright (c) 2025, WONG Sai Lung. All rights reserved.
 *
 * @author WONG, Sai Lung
 * @version v1.0.0
 */
public class Main {
    public static void main(String[] args) {

        // ############################################################################
        // #                                                                          #
        // #                              Initialization                              #
        // #                                                                          #
        // ############################################################################
        Scanner scanner = new Scanner(System.in);


        // ############################################################################
        // #                                                                          #
        // #                                   Setup                                  #
        // #                                                                          #
        // ############################################################################
        System.out.println("------------- SETUP SIMULATION ENVIRONMENT -------------");
        int simulationLength = getInput(scanner, "Input simulation length (min): ", "Simulation length must be greater than 0");
        int counter = getInput(scanner, "Input number of counter: ", "Number of counter must be greater than 0");


        // ############################################################################
        // #                                                                          #
        // #                                   Start                                  #
        // #                                                                          #
        // ############################################################################
        System.out.println("------------- START SIMULATION -------------");
        System.out.println();
        Simulation s = new Simulation(simulationLength, counter);
        s.runSimulation();


        // ############################################################################
        // #                                                                          #
        // #                                    End                                   #
        // #                                                                          #
        // ############################################################################
        System.out.println("------------- END OF SIMULATION -------------");
        System.out.printf("Total minute simulated: %d minutes\n", simulationLength);
        System.out.printf("Number of Tellers: %d\n", counter);
        System.out.printf("Number of customer served: %d customers\n", s.getTotalCustomerServed());
        System.out.printf("Average of customer wait in the queue: %f customers\n", s.getAverageCustomerInQueue());
        System.out.printf("Maximum queue length during the simulation: %d customers\n", s.getMaxCustomerInQueue());

    }
    
    /**
     * Get a valid integer input from the user.
     *
     * @param scanner      The Scanner object to read input
     * @param prompt       The prompt message to display
     * @param errorMessage The error message to display for invalid input
     * @return The valid integer input
     */
    private static int getInput(Scanner scanner, String prompt, String errorMessage) {
        int input;
        while (true) {
            System.out.print(prompt);
            try {
                input = scanner.nextInt();
                if (input < 1) {
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