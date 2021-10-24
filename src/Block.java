//208384420

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * This class define the Block object.
 * each block has a rectangle.
 * the class implements the collidable and sprite interface.
 * The class contains the following functions:
 * A function that change velocity according to where the ball hit.
 * A function that draw the block.
 * A function that add the object to the game.
 * Besides them, there are a function that return the rectangle.
 *
 * @author Yahel Jacoby
 */
public class Block implements Collidable, Sprite, HitNotifier {

    private Rectangle rectangle;
    private static final double EPSILON = Math.pow(10, -2);
    private List<HitListener> hitListeners;

    /**
     * This function is the constructor.
     *
     * @param rectangle is the rectangle of the block
     */
    public Block(Rectangle rectangle) {
        this.rectangle = rectangle;
        this.hitListeners = new ArrayList<>();

    }

    /**
     * return the rectangle that there is a intersection with.
     *
     * @return the rectangle
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return rectangle;
    }

    /**
     * This function get a collision point, and creat a new velocity according to the line the rectangle hit.
     *
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity of the ball
     * @return a new velocity
     */

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        if (Math.abs(collisionPoint.getX() - this.rectangle.getBottomRight().getX()) < EPSILON
                || Math.abs(collisionPoint.getX() - this.rectangle.getUpperLeft().getX()) < EPSILON) {
            currentVelocity = new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());

        }
        if (Math.abs(collisionPoint.getY() - this.rectangle.getBottomRight().getY()) < EPSILON
                || Math.abs(collisionPoint.getY() - this.rectangle.getUpperLeft().getY()) < EPSILON) {
            currentVelocity = new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());

        }
        this.notifyHit(hitter);
        return currentVelocity;
    }

    /**
     * Draw the block on the screen.
     *
     * @param surface the surface of the game
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.rectangle.getColor());
        int intX = (int) this.rectangle.getUpperLeft().getX();
        int intY = (int) this.rectangle.getUpperLeft().getY();
        int width = (int) this.rectangle.getWidth();
        int height = (int) this.rectangle.getHeight();
        surface.fillRectangle(intX, intY, width, height);
        surface.setColor(this.rectangle.getFrame());
        surface.drawRectangle(intX, intY, width, height);
    }

    /**
     * The function has not yet been implemented.
     */
    @Override
    public void timePassed() {

    }

    /**
     * Add a block to the game.
     *
     * @param gameLevel the current game
     */

    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
        gameLevel.addCollidable(this);
    }

    /**
     * remove a block from the game.
     * @param gameLevel represent the game
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }

    /**
     * Notify all listeners about a hit event.
     * @param hitter the ball how hit the block
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }


}