package pig;

import player.*;

import java.util.Scanner;

/**
 * Gabe Castelli
 * 10/31/16
 * Description: Console dice game involving luck and risk
 */

class Main {
    public static void main(String[] args) {
        boolean keepPlaying;
        Scanner stdin = new Scanner(System.in);
        System.out.print("Enter username: ");
        final String username = stdin.next();

        do {
            keepPlaying = false;
            Player user = new User(username);
            Player ai = new AI();

            do {
                user.takeTurn();
                ai.takeTurn();
            } while (!(user.hasWon() || ai.hasWon()));

            announceWinner(user.hasWon() ? user : ai);
            System.out.print("Play again? (y / n): ");
            String input = stdin.next();
            while (!(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n"))) {
                System.out.print("Please enter y or n: ");
                input = stdin.next();
            }
            keepPlaying = input.equalsIgnoreCase("y");
            System.out.println();
        } while (keepPlaying);

        stdin.close();
    }

    private static void announceWinner(Player winner) {
        System.out.println(winner.getName() + " has won with a score of " + winner.getScore() + "!");
    }
}