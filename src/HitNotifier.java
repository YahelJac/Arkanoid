//208384420
/**
 * this interface is been implemented by class that need to notify when there is a hit.
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     * @param hl is a listener
     */
    void addHitListener(HitListener hl);
    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl is a listener
     */
    void removeHitListener(HitListener hl);
}