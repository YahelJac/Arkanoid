//208384420

import biuoop.DrawSurface;

/**
 * this class counting the score of the game and print it on the top of the screen.
 * implement HitListener and sprite
 */
public class ScoreTrackingListener implements HitListener, Sprite {
    private GameLevel gameLevel;
    private Counter currentScore;
    private String text;

    /**
     * the constructor.
     *
     * @param gameLevel the starting point score
     */

    public ScoreTrackingListener(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
        this.currentScore = gameLevel.getCounterScore();
        this.text = "Score: " + String.valueOf(currentScore.getValue());
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        gameLevel.increasScore(5);


    }

    @Override
    public void drawOn(DrawSurface d) {
        this.text = "Score: " + String.valueOf(currentScore.getValue());
        d.drawText(150, 13, this.text, 15);
        d.drawText(600, 13, gameLevel.getLevelName(), 15);
        d.drawText(400, 13, "Lives: " + String.valueOf(gameLevel.getCounterLives().getValue()), 15);
    }

    @Override
    public void timePassed() {

    }
}
