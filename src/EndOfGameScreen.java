//208384420
import biuoop.DrawSurface;


import java.awt.Color;

/**
 * the class of the EndOfGameScreen screen.
 */
public class EndOfGameScreen implements Animation {


    private int score;

    /**
     * this is the constructor.
     * @param score the score when the user lose
     */
    public EndOfGameScreen(int score) {
        this.score = score;
    }
@Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(new Color(210, 135, 135));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.WHITE);
        d.fillCircle(400, 300, 100);
        d.setColor(Color.BLACK);
        d.fillCircle(350, 270, 10);
        d.fillCircle(450, 270, 10);
        d.fillRectangle(320, 330, 160, 5);

        d.drawText(200, d.getHeight() / 4, "Game Over. Your score is " + score, 32);

    }
@Override
    public boolean shouldStop() {
        return false;
    }
}
