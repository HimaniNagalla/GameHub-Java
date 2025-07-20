import java.util.Scanner;

public class GameHub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== WELCOME TO GAME HUB =====");
            System.out.println(" ------------------- ▀▄▀▄▀▄   GAME HUB   ▄▀▄▀▄▀ -------------------\n");
            System.out.println(" ★⋆ 1. ROCK PAPER SCISSORS");
            System.out.println(" ★⋆ 2. GUESS THE NUMBER");
            System.out.println(" ★⋆ 3. GENERAL KNOWLEDGE QUIZ");
            System.out.println(" ★⋆ 4. TIC TAC TOE");
            System.out.println(" ★⋆ 5. ANAGRAM SOLVER");
            System.out.println(" ★⋆ 6. QUIT");

            System.out.print("\n ➤➤➤➤  Choose a game (1-6): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    RockPaperScissors.play(scanner);
                    break;
                case "2":
                    GuessTheNumber.play(scanner);
                    break;
                case "3":
                    GeneralKnowledgeQuiz.play(scanner);
                    break;
                case "4":
                    TicTacToe.play(scanner);
                    break;
                case "5":
                    AnagramSolver.play(scanner);
                    break;
                case "6":
                    System.out.println("\nThank you for playing Game Hub!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.\n");
            }
        }
    }
}
