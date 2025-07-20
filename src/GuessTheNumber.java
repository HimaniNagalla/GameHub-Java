import java.util.*;

public class GuessTheNumber {

    public static void play(Scanner scanner) {
        System.out.print("\nChoose level... Type 'easy' or 'hard': ");
        String level = scanner.nextLine().toLowerCase();

        Game game = new Game(level, scanner);
        game.startGame();
    }
}

class Game {
    private int secretNumber;
    private int attempts;
    private final Scanner scanner;
    private final String level;

    Game(String level, Scanner scanner) {
        this.level = level;
        this.scanner = scanner;
        Random rand = new Random();
        secretNumber = rand.nextInt(50) + 1; // between 1 and 50
        attempts = level.equals("easy") ? 10 : 5;
    }

    public void startGame() {
        System.out.println("\n------------------- GUESS THE NUMBER -------------------");
        System.out.println("I'm thinking of a number between 1 and 50.");

        while (attempts > 0) {
            System.out.println("\nYou have " + attempts + " attempts left.");
            System.out.print("Have a guess: ");

            try {
                int userGuess = Integer.parseInt(scanner.nextLine());

                if (userGuess < 1 || userGuess > 50) {
                    System.out.println("Invalid input! Enter a number between 1 and 50.");
                    continue;
                }

                if (userGuess == secretNumber) {
                    System.out.println("🎉 Congrats! You guessed the number.");
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                attempts--;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }

        if (attempts == 0) {
            System.out.println("\n😢 You ran out of attempts. The correct number was " + secretNumber + ".");
        }

        System.out.print("\nDo you want to play again? (yes/no): ");
        String again = scanner.nextLine().toLowerCase();

        if (again.equals("yes")) {
            Game newGame = new Game(this.level, scanner);  // Reuse the level
            newGame.startGame();
        } else {
            System.out.println("Thank you for playing Guess the Number!");
        }
    }
}
