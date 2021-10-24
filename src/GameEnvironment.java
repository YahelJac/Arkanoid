//208384420

import java.util.ArrayList;

/**
 * This class define the game environment.
 * each game environment has a list of collidable.
 * The class contains the following functions:
 * A function that add a new collidable to the list
 * A function that gets the closest collision point
 *
 * @author Yahel Jacoby
 */
public class GameEnvironment {

    private Collidable c;
    private java.util.List<Collidable> l1;

    /**
     * This function is the constructor.
     */
    public GameEnvironment() {
        l1 = new ArrayList<>();
    }

    /**
     * add a new collidable to the list.
     *
     * @param collidable the new collidable
     */
    public void addCollidable(Collidable collidable) {
        l1.add(collidable);
    }

    /**
     * remove a collidable object.
     *
     * @param collidable the object to remove
     */
    public void removeCollidable(Collidable collidable) {
        l1.remove(collidable);
    }


    /**
     * check what is the closest collision point in the trace of the ball from all the collidable object in the list.
     *
     * @param trajectory the trace of the ball
     * @return the closet collision point and the collidable object.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        java.util.List<Point> l2 = new ArrayList<>();
        java.util.List<Collidable> l3 = new ArrayList<>();
        //creat an array of all the object that are collide with the ball
        for (int i = 0; i < l1.size(); i++) {
            Collidable temp = l1.get(i);
            if (temp.getCollisionRectangle().intersectionPoints(trajectory) != null
                    && temp.getCollisionRectangle().intersectionPoints(trajectory).size() != 0) {
                Point check = trajectory.closestIntersectionToStartOfLine(temp.getCollisionRectangle());
                l2.add(trajectory.closestIntersectionToStartOfLine(temp.getCollisionRectangle()));
                l3.add(temp);
            }
        }
        //if there is no object
        if (l2.isEmpty() || l2 == null) {
            return null;
        }
        //find the closest one
        Point closest = l2.get(0);
        Collidable closestCollidable = l3.get(0);
        for (int i = 0; i < l2.size(); i++) {
            Collidable temp1 = l3.get(i);
            Point p = trajectory.closestIntersectionToStartOfLine(temp1.getCollisionRectangle());
            if (p != null) {
                if (trajectory.start().distance(closest) > trajectory.start().distance(p)) {
                    closest = trajectory.closestIntersectionToStartOfLine((l3.get(i)).getCollisionRectangle());
                    closestCollidable = l3.get(i);
                }
            }
        }
        CollisionInfo closestCollision = new CollisionInfo(closest, closestCollidable);
        return closestCollision;
    }
}