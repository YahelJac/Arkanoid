//208384420

/**
 * A interface of object that are collidable.
 */

public interface Collidable {
    //

    /**
     * Return the "collision shape" of the object.
     * @return the object
     */
    Rectangle getCollisionRectangle();

    /**
     * Calculate the new velocity after the hit occurred.
     * @param collisionPoint the point of the collision
     * @param currentVelocity the ole velocity
     * @param hitter the ball how hit the blocks
     * @return the new velocity
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}