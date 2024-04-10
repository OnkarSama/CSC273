import java.util.EmptyStackException;
import java.util.Random;

/**
 * A class to simulate the "King of Stacks" game.
 */
public class KingOfStacks {

    // Three stacks for the game
    private StackInterface<Disk> stackA = new VectorStack<>();
    private StackInterface<Disk> stackB = new VectorStack<>();
    private StackInterface<Disk> stackC = new VectorStack<>();

    // Number of rounds to play
    private int numberOfRounds;
    private final static int MIN_NUM_OF_ROUNDS = 30;

    // Rounds at which disks should be popped from stacks
    private final int[] popRounds = {3, 5, 8};

    // Current round of the game
    private int currentRound = 1;

    /**
     * Constructs a KingOfStacks game with a specified number of rounds.
     *
     * @param numberOfRounds The number of rounds to play.
     */
    public KingOfStacks(int numberOfRounds) {

        this.numberOfRounds = Math.max(numberOfRounds, MIN_NUM_OF_ROUNDS);
    }

    /**
     * Pops disks from stacks according to predefined rounds.
     */
    private void pop() {

        for(int popRound : popRounds) {
            if(currentRound % popRound == 0) {
                switch(popRound) {
                    case 3:
                        popDisk(stackA, "A");
                        break;
                    case 5:
                        popDisk(stackB, "B");
                        break;
                    case 8:
                        popDisk(stackC, "C");
                        break;
                }
            }
        }
    }

    /**
     * Pops a disk from a given stack and handles exceptions (helper method).
     *
     * @param stack     The stack to pop from.
     * @param stackName The name of the stack for logging purposes.
     */
    private void popDisk(StackInterface<Disk> stack, String stackName) {

        try {
            stack.pop();
            System.out.println("A disk was popped from Stack " + stackName);
        } catch(EmptyStackException e) {
            System.out.println("Tried to pop from empty Stack " + stackName);
        }
    }

    /**
     * Ends the game and tallies scores.
     */
    private void endGame() {

        int playerOneTally = 0;
        int playerTwoTally = 0;

        // Pop all disks from stacks and tally scores
        while(!stackA.isEmpty()) {
            Disk poppedDisk = stackA.pop();
            if(poppedDisk.getPlayerMarker() == 1) {
                playerOneTally++;
            } else if(poppedDisk.getPlayerMarker() == 2) {
                playerTwoTally++;
            }
        }
        while(!stackB.isEmpty()) {
            Disk poppedDisk = stackB.pop();
            if(poppedDisk.getPlayerMarker() == 1) {
                playerOneTally++;
            } else if(poppedDisk.getPlayerMarker() == 2) {
                playerTwoTally++;
            }
        }
        while(!stackC.isEmpty()) {
            Disk poppedDisk = stackC.pop();
            if(poppedDisk.getPlayerMarker() == 1) {
                playerOneTally++;
            } else if(poppedDisk.getPlayerMarker() == 2) {
                playerTwoTally++;
            }
        }

        // Print scores
        System.out.println();
        System.out.println("End of the game. Scores tallied.");
        System.out.println("Player 1 Score: " + playerOneTally);
        System.out.println("Player 2 Score: " + playerTwoTally);
    }

    /**
     * Retrieves a stack by its index.
     *
     * @param index The index of the stack (1, 2, or 3).
     *
     * @return The stack corresponding to the index.
     * @throws IllegalArgumentException If the index is invalid.
     */
    private StackInterface<Disk> getStackByIndex(int index) {

        switch(index) {
            case 1:
                return stackA;
            case 2:
                return stackB;
            case 3:
                return stackC;
            default:
                throw new IllegalArgumentException("Invalid stack index");
        }
    }

    /**
     * Simulates the entire game.
     */
    public void simulateGame() {

        while(currentRound <= numberOfRounds) {
            simulateRound();
            currentRound++;
        }
        endGame();
    }

    /**
     * Simulates a single round of the game.
     */
    private void simulateRound() {

        simulatePlayerTurn();
        pop();
    }

    /**
     * Simulates a player's turn in a round.
     */
    private void simulatePlayerTurn() {

        int turn = 1;
        System.out.println();
        System.out.println("The Current Round is: " + currentRound);

        Random random = new Random();

        // Perform two turns, one for each player
        for(int i = 1; i <= 2; i++) {
            // Choose a random stack
            int stackIndex = random.nextInt(3) + 1;
            StackInterface<Disk> stack = getStackByIndex(stackIndex);
            // Print turn information and push a disk onto the chosen stack
            if(i == 1) {
                System.out.println("Turn " + turn + ": Player " + 1 + " pushes disk onto Stack " + stackIndex);
                stack.push(new Disk(1));
            } else {
                System.out.println("Turn " + turn + ": Player " + 2 + " pushes disk onto Stack " + stackIndex);
                stack.push(new Disk(2)); // Assign random player marker (1 or 2)
            }
            turn++;
        }
    }

}
