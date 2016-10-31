package dice;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Gabe Castelli
 * 10/31/16
 */

public class Dice {
    public static byte[] roll() {
        try {
            SecureRandom sr = SecureRandom.getInstanceStrong();
            byte[] dice = new byte[2];
            sr.nextBytes(dice);
            for (int i = 0; i < 2; i++) {
                dice[i] %= 6;
                dice[i] = (byte) Math.abs(dice[i]);
                dice[i]++;
            }
            return dice;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}