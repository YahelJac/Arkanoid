//208384420


/**
 * This class define the collision information.
 * A collision information contain a collidable object and collision point
 *
 * @author Yahel Jacoby
 */
public class CollisionInfo {

    private Collidable collisionObject;
    private Point collisionPoint;

    /**
     * This function is the constructor.
     * @param collisionObject the collision object
     * @param collisionPoint the collision point
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionObject = collisionObject;
        this.collisionPoint = collisionPoint;
    }

    /**
     * return the point at which the collision occurs.
     * @return collision point
     */
    public Point collisionPoint() {
        return collisionPoint;
    }
    /**
     * return the collidable object involved in the collision.
     * @return collision object
     */

    public Collidable collisionObject() {
        return collisionObject;
    }
}