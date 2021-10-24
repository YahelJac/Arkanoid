//208384420

/**
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * This function is the constructor.
     * @param gameLevel represent the game
     * @param removedBlocks the number of blocks that remain
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.

    /**
     * remove the block from the game when it get hit.
     * @param beingHit the block
     * @param hitter the ball how hit the block
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(gameLevel);
        remainingBlocks.decrease(1);
    }
}