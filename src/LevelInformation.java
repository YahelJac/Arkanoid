//208384420
import java.util.List;

import biuoop.DrawSurface;

/**
 * this is the interface for the levels class.
 */
public interface LevelInformation {
    /**
     * the number of balls.
     * @return the num of balls
     */
    int numberOfBalls();

    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()

    /**
     * initial the balls velocity.
     * @return a list of velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * the paddle speed.
     * @return the paddle speed
     */
    int paddleSpeed();

    /**
     * the paddle width.
     * @return the paddle width
     */
    int paddleWidth();

    /**
     * the level name will be displayed at the top of the screen.
     * @return the level name
     */
     String levelName();

     /**
     * Returns a sprite with the background of the level.
     * @return a sprite with the background of the level
     */
    Sprite getBackground();

     /**
     * The Blocks that make up this level, each block contains. its size, color and location.
     * @return a list of blocks
     */
    List<Block> blocks();

    /**
     * Number of blocks that should be removed.
     * @return the number of blocks to remove
     */
    int numberOfBlocksToRemove();

    /**
     * this function creat the background.
     * @param d the surface
     */
    void creatBackGround(DrawSurface d);
}