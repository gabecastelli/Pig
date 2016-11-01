package player;

import dice.Dice;
import java.util.Scanner;

/**
 * Gabe Castelli
 * 10/31/16
 */

public class User extends Player {
    private Scanner stdin;

    public User(String name_) {
        super(name_);
        stdin = new Scanner(System.in);
    }

    public void takeTurn() {
        boolean rollAgain;
        byte points = 0;

        do {
            rollAgain = false;
            byte[] dice = Dice.roll();
            if (dice[0] == 1 || dice[1] == 1) {
                if (dice[0] == 1 && dice[1] == 1) {
                    System.out.println("You rolled two 1's! Score reset");
                    reset();
                    endTurn();
                } else {
                    System.out.println("You rolled a 1! Score for current turn reset");
                    points = 0;
                    endTurn();
                }
            } else {
                System.out.println("You rolled a " + dice[0] + " and a " + dice[1]);
                points += dice[0] + dice[1];

                if (score + points >= 100) { // User has won
                    updateScore(points);
                    System.out.println();
                } else {
                    System.out.print("Roll again? (y / n): ");
                    String input = stdin.next();
                    while (!(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n"))) {
                        System.out.print("Please enter y or n: ");
                        input = stdin.next();
                    }
                    rollAgain = input.equalsIgnoreCase("y");
                    if (!rollAgain) {
                        updateScore(points);
                        endTurn();
                    }
                }
            }
        } while (rollAgain);
    }
}