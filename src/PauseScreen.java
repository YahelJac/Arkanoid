//208384420

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * the pause screen animation.
 */
public class PauseScreen implements Animation {
    /**
     * the constructor.
     */
    public PauseScreen() {

    }
@Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(new Color(209, 179, 248));
        d.fillRectangle(0, 0, 800, 600);

        d.setColor(Color.BLACK);
        d.drawText(150, d.getHeight() / 2, "paused -- press space to continue", 32);


    }
@Override
    public boolean shouldStop() {
        return false;
    }
}