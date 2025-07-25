import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void play(Scanner scanner) {
        String[] options = {"rock", "paper", "scissors"};
        Random random = new Random();

        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.print("Enter your choice (rock/paper/scissors): ");
        String userChoice = scanner.nextLine().toLowerCase();

        if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
            System.out.println("Invalid choice. Please enter rock, paper, or scissors.");
            return;
        }

        String computerChoice = options[random.nextInt(3)];
        System.out.println("Computer chose: " + computerChoice);

        if (userChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if (
            (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
            (userChoice.equals("paper") && computerChoice.equals("rock")) ||
            (userChoice.equals("scissors") && computerChoice.equals("paper"))
        ) {
            System.out.println("You win!");
        } else {
            System.out.println("Computer wins!");
        }
    }
}
