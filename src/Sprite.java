//208384420

import biuoop.DrawSurface;

/**
 * A interface of object that are sprite.
 */
public interface Sprite {
     /**
     * draw the sprite to the screen.
     * @param d the surface
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}