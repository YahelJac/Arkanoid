//208384420

import biuoop.Sleeper;
import biuoop.DrawSurface;

/**
 * this animation is responsible on the count down in the beginning of every level.
 */
public class CountdownAnimation implements Animation {

    private double numOfseconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    private int counter;

    /**
     * this is the constructor.
     * @param numOfSeconds how many seconds the count down lasts
     * @param countFrom the number the count start from
     * @param gameScreen the screen of the level that is starting
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfseconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
        this.counter = countFrom;
    }
    @Override
    public void doOneFrame(DrawSurface d) {

        gameScreen.drawAllOn(d);
        d.drawText(d.getWidth() / 2 - 10, d.getHeight() / 2, String.valueOf(counter), 32);
        Sleeper sleeper = new Sleeper();

        if (counter == 0) {
            this.stop = true;
        }

        if (counter != countFrom) {
            sleeper.sleepFor((long) ((numOfseconds / countFrom) * 1000));
        }
        counter = counter - 1;
    }

@Override
    public boolean shouldStop() {
        return this.stop;
    }
}