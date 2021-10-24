//208384420

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * This class define the ball object.
 * each ball has a center point, radius and color.
 * The class contains the following functions:
 * A function that draw thw ball on the draw surface
 * A function that set velocity to the ball.
 * functions that return details of the ball.
 * A function that makes the ball move on the screen
 * Besides them, there are function that help to execute the main functions
 *
 * @author Yahel Jacoby
 */
public class Ball implements Sprite, HitNotifier {
    private Point center;
    private double x;
    private double y;
    private int r;
    private Velocity velocity;
    private java.awt.Color color;
    private Point point;
    private GameEnvironment gameEnvironment;
    private List<HitListener> hitListeners;


    /**
     * This function is the constructor.
     *
     * @param center represent the center of the ball
     * @param r      represent the radius of the ball
     * @param color  represent the color of the ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.x = (int) center.getX();
        this.y = (int) center.getY();
        this.r = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
        this.point = center;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * This function is the constructor, only the center point is been created in the function by geting x,y.
     *
     * @param x     represent the x of the center
     * @param y     represent the y of the center
     * @param r     represent the radius of the ball
     * @param color represent the color of the ball
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.x = (int) x;
        this.y = (int) y;
        this.r = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
        this.center = new Point(x, y);
        this.point = center;
    }

    /**
     * Return the the x of the center of the ball.
     *
     * @return x (int)
     */
    public int getX() {
        return (int) center.getX();
    }

    /**
     * Return the the y of the center of the ball.
     *
     * @return y (int)
     */
    public int getY() {
        return (int) center.getY();
    }

    /**
     * Return the size of the ball.
     *
     * @return the size of the ball (int)
     */
    public int getSize() {
        return this.r;
    }

    /**
     * Return the color of the ball.
     *
     * @return the color of the ball (Color)
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Draw the ball on the given DrawSurface.
     *
     * @param surface represent the screen
     */

    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        int intX = (int) this.x;
        int intY = (int) this.y;
        surface.fillCircle(intX, intY, this.r);
    }

    /**
     * Set the size of the frame in which the ball moves.
     *
     * @param screenHeight represent the height of the screen
     * @param screenWidth  represent the width of the screen
     * @param screenStart  represents the point from which the ball begins to move
     */
//    public void setSize(int screenHeight, int screenWidth, int screenStart) {
//        this.height = screenHeight;
//        this.width = screenWidth;
//        this.start = screenStart;
//    }

    /**
     * Set the velocity of the ball by sending a giving velocity.
     *
     * @param v represent the velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;

    }

    /**
     * Set the velocity of the ball by sending dx and dy.
     *
     * @param dx represent dx of the velocity
     * @param dy represent dy of the velocity
     */
    public void setVelocity(double dx, double dy) {
        Velocity v = new Velocity(dx, dy);
        this.velocity = v;

    }

    /**
     * Return the velocity of a ball.
     *
     * @return velocity (Velocity)
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * call move one step.
     */


    @Override
    public void timePassed() {
        moveOneStep();
    }

    /**
     * A function that move the center of the ball so that the ball move on the screen.
     * it create a line from the center of the ball to where the ball should go.
     * if there is a collision, it calls to other function to get a new velocity and move the ball closer to the
     * collision.
     */
    public void moveOneStep() {
        //Calls a function that calculates the new point and returns x,y
        this.point = this.getVelocity().applyToPoint(this.point);
        Line temp = new Line(center, point);
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(temp);
        //if there is a collision
        if (collisionInfo != null) {
            this.velocity = collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(), this.velocity);
            //if somehow the ball got inside ine if the blocks
            if (this.center.getY() >= collisionInfo.collisionObject().getCollisionRectangle().getUpperLeft().getY()
                    && this.center.getY()
                    <= collisionInfo.collisionObject().getCollisionRectangle().getBottomLeft().getY()
                    && this.center.getX()
                    >= collisionInfo.collisionObject().getCollisionRectangle().getUpperLeft().getX()
                    && this.center.getX()
                    <= collisionInfo.collisionObject().getCollisionRectangle().getBottomRight().getX()) {
                this.center = getVelocity().applyToPoint(this.center);
            }
            //find a middle point to take the ball closer to the object
            double newX = (this.center.getX() + collisionInfo.collisionPoint().getX()) / 2;
            double newY = (this.center.getY() + collisionInfo.collisionPoint().getY()) / 2;
            Point newPoint = new Point(newX, newY);
            this.point = newPoint;
            this.x = (int) newPoint.getX();
            this.y = (int) newPoint.getY();
            this.center = newPoint;

            return;
        }
        //if there is no collision
        this.x = (int) point.getX();
        this.y = (int) point.getY();
        this.center = point;
    }

    /**
     * add a ball to the game.
     *
     * @param gameLevel the currant game
     */
    public void addToGame(GameLevel gameLevel) {
        gameLevel.addSprite(this);
    }

    /**
     * set the game environment of the ball.
     *
     * @param gameEnvironment1 the game environment
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment1) {
        this.gameEnvironment = gameEnvironment1;
    }

    /**
     * return the center of the point.
     *
     * @return center of the ball
     */
    public Point getCenter() {
        return center;
    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }


}