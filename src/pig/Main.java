package pig;

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
        } while (keepPlaying);

        stdin.close();
    }
}