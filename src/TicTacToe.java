import java.util.Scanner;

public class TicTacToe {
    private char[] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[9];
        for (int i = 0; i < 9; i++) {
            board[i] = (char) ('1' + i);
        }
        currentPlayer = 'X';
    }

    public void printBoard() {
        System.out.println();
        for (int i = 0; i < 9; i++) {
            System.out.print(" " + board[i] + " ");
            if (i % 3 != 2) {
                System.out.print("|");
            }
            if (i % 3 == 2 && i != 8) {
                System.out.println("\n-----------");
            }
        }
        System.out.println("\n");
    }

    public boolean makeMove(int pos) {
        if (pos < 1 || pos > 9 || board[pos - 1] == 'X' || board[pos - 1] == 'O') {
            return false;
        }
        board[pos - 1] = currentPlayer;
        return true;
    }

    public boolean checkWin() {
        int[][] winConditions = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
        };

        for (int[] combo : winConditions) {
            if (board[combo[0]] == currentPlayer &&
                board[combo[1]] == currentPlayer &&
                board[combo[2]] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    public boolean isDraw() {
        for (char c : board) {
            if (c != 'X' && c != 'O') {
                return false;
            }
        }
        return true;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public static void play(Scanner scanner) {
        TicTacToe game = new TicTacToe();
        System.out.println("TIC TAC TOE Game Started!");
        game.printBoard();

        while (true) {
            System.out.print("Player " + game.currentPlayer + ", enter a position (1-9): ");
            String input = scanner.nextLine();

            int position;
            try {
                position = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 9.");
                continue;
            }

            if (!game.makeMove(position)) {
                System.out.println("Invalid move! Position already taken or out of bounds.");
                continue;
            }

            game.printBoard();

            if (game.checkWin()) {
                System.out.println("Player " + game.currentPlayer + " wins!");
                break;
            }

            if (game.isDraw()) {
                System.out.println("Game is a draw!");
                break;
            }

            game.switchPlayer();
        }
    }
}
