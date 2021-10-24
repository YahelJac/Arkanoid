//208384420

import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;
import java.util.Random;

/**
 * the class of the WinScreen screen.
 */
public class WinScreen implements Animation {

    private int score;

    /**
     * this is the constructor.
     * @param score the current score
     */
    public WinScreen(int score) {

        this.score = score;
    }
@Override
    public void doOneFrame(DrawSurface d) {
        Random rand = new Random();
        Sleeper sleeper = new Sleeper();

        d.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.BLACK);
        d.drawText(100, d.getHeight() / 2, "You Win! Your score is " + score, 50);
        sleeper.sleepFor(100);


    }
@Override

    public boolean shouldStop() {
        return false;
    }
}
