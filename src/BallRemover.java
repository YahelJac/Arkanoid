//208384420

/**
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * This function is the constructor.
     *
     * @param gameLevel represent the game
     * @param removedBalls the number of balls that remain.
     */
    public BallRemover(GameLevel gameLevel, Counter removedBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBalls;

    }

    /**
     * remove the block from the game when it get hit.
     * @param beingHit the block
     * @param hitter the ball how hit the block
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        remainingBalls.decrease(1);
        hitter.removeHitListener(this);
        gameLevel.removeSprite(hitter);

    }
}