import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Driver class to start and run the "King of Stacks" game.
 */
public class Driver {

    public static void main(String[] args) {

        KingOfStacks game;

        Scanner input = new Scanner(System.in);

        int numberOfRounds = 0;

        // Displaying the rules to the user
        System.out.println(
                """
                        Rules:
                            There must be at least 30 rounds in the game
                            If you enter a number less than 30 rounds the
                            game will be defaulted to 30 rounds.\s
                        """
        );

        boolean validInput = false;

        // Prompting the user to enter the number of rounds
        do {
            System.out.print("Please enter the number of rounds wanted: ");
            try {
                numberOfRounds = input.nextInt();
                // Checking if the entered number is less than 30 and defaulting if so
                if(numberOfRounds < 30) {
                    System.out.println("You entered a number less than 30. Defaulting to 30 rounds.");
                    numberOfRounds = 30;
                }
                validInput = true;
            } catch(InputMismatchException e) {
                // Handling invalid input
                System.out.println();
                System.out.println("Invalid input. Please enter an integer.");
                System.out.println();
                input.next(); // Clear the invalid input
            }
        } while(!validInput);

        // Creating a new instance of the game with the specified number of rounds
        game = new KingOfStacks(numberOfRounds);

        System.out.println();

        // Starting the game simulation
        game.simulateGame();
    }

}
