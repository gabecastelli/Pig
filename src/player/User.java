package player;

import java.util.Scanner;

/**
 * Gabe Castelli
 * 10/31/16
 */

public class User extends Player {
    private static final String ID = "USER";

    public User(String name_) {
        super(name_);
    }

    public void takeTurn() {

    }

    public final String getID() {
        return ID;
    }
}