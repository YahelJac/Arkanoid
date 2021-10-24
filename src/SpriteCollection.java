//208384420

import biuoop.DrawSurface;

import java.util.ArrayList;

/**
 * This class define the sprite collection.
 * A sprite collection contain a array of sprits.
 * The class contains the following functions:
 * a function that call timePassed() on all sprites.
 * a function that call drawOn(d) on all sprites.
 *
 * @author Yahel Jacoby
 */

public class SpriteCollection {

    private java.util.List<Sprite> l1;

    /**
     * This function is the constructor.
     */
    public SpriteCollection() {
        l1 = new ArrayList<>();
    }

    /**
     * add a new sprite to the collection.
     *
     * @param s the new sprite
     */
    public void addSprite(Sprite s) {
        l1.add(s);
    }

    /**
     * remove sprite from list.
     * @param s remove this sprite
     */
    public void removeSprite(Sprite s) {
        l1.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < l1.size(); i++) {
            l1.get(i).timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d the surface
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < l1.size(); i++) {
            l1.get(i).drawOn(d);
        }
    }

    /**
     * return the sprite collection.
     *
     * @return l1
     */
    public java.util.List<Sprite> getSpriteCollection() {
        return l1;
    }

}