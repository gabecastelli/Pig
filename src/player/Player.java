package player;

/**
 * Gabe Castelli
 * 10/31/16
 * Description: Base class for User and AI which defines core methods
 */

public abstract class Player {
    protected String name;
    protected byte score;

    protected Player(String name_) {
        name = name_;
        score = 0;
    }

    public abstract void takeTurn();

    protected void reset() {
        score = 0;
    }

    public boolean hasWon() {
        return score >= 100;
    }

    public void endTurn() {
        System.out.println(name + " has " + score + " points\n");
    }

    public String getName() {
        return name;
    }

    public byte getScore() {
        return score;
    }

    public void updateScore(byte score_) {
        score += score_;
    }
}