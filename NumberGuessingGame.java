import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1;  // Generate a random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("\nI have generated a random number between 1 and 100. Try to guess it!");
            System.out.println("You have " + maxAttempts + " attempts.");

            // Loop until the user guesses correctly or runs out of attempts
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    score += maxAttempts - attempts + 1;  // Higher score for fewer attempts
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            // If user runs out of attempts
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + randomNumber);
            }

            // Ask if the user wants to play again
            System.out.print("\nWould you like to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("\nGame Over! Your final score is: " + score);
        scanner.close();
    }
}
