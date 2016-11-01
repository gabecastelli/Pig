package player;

import dice.Dice;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

/**
 * Gabe Castelli
 * 10/31/16
 */

public class AI extends Player {
    public AI() {
        super("Computer");
    }

    public void takeTurn() {
        boolean rollAgain;
        byte points = 0;

        do {
            rollAgain = false;
            byte[] dice = Dice.roll();
            if (dice[0] == 1 || dice[1] == 1) {
                if (dice[0] == 1 && dice[1] == 1) {
                    System.out.println(name + " rolled two 1's! Score reset");
                    reset();
                    endTurn();
                } else {
                    System.out.println(name + " rolled a 1! Score for current turn reset");
                    points = 0;
                    endTurn();
                }
            } else {
                System.out.println(name + " rolled a " + dice[0] + " and a " + dice[1]);
                points += dice[0] + dice[1];

                if (score + points >= 100) { // Computer has won
                    updateScore(points);
                    System.out.println();
                } else {
                    rollAgain = rollAgain();
                    if (rollAgain) {
                        System.out.println(name + " is rolling again...");
                    } else {
                        System.out.println(name + " has ended their turn");
                        updateScore(points);
                        endTurn();
                    }
                }
            }
        } while (rollAgain);
    }

    public boolean rollAgain() {
        try {
            SecureRandom sr = new SecureRandom().getInstanceStrong();
            byte result = (byte) (sr.nextInt() % 4);
            return result == 0 || result == 1 || result == 2; // 3/4 probability to roll again
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }
}
