import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 5;
        int totalRounds = 0;
        int roundsWon = 0;
        String playAgain;

        // Welcome message
        System.out.println("Welcome to the Number Guessing Game!");

        do {
            // Generate random number between 1 and 100
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " chances to guess it.");

            // Let the user guess the number
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You guessed it in " + attempts + " attempt(s).");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low.");
                } else {
                    System.out.println("Too high.");
                }
            }

            // If not guessed correctly
            if (!guessedCorrectly) {
                System.out.println("Sorry! You used all attempts. The number was " + numberToGuess + ".");
            }

            totalRounds++;

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        // Game summary
        System.out.println("\nGame Over.");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Rounds won: " + roundsWon);

        scanner.close();
    }
}
