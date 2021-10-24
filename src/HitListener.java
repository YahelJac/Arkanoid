//208384420
/**
 * this interface is been implemented by class that need to know when there is a hit.
 */
public interface HitListener {

    /**
     * This method is called whenever the beingHit object is hit.
     * @param beingHit the object how been hit
     * @param hitter the object how hit
     */
    void hitEvent(Block beingHit, Ball hitter);
}