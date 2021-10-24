//208384420

/**
 * This class define the velocity.
 * each velocity has dx and dy.
 * The class contains the following functions:
 * A function that calculate dx and xy by gating an angle and speed
 * A function that calculate a new point by using dx and dy
 * functions that return dx and dy of velocity.
 *
 * @author Yahel Jacoby
 */

public class Velocity {
    private double dx;
    private double dy;

    /**
     * This function represent the constructor.
     * @param dx represent the dx
     * @param dy represent the dy
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /**
     * Calculate dx and xy by gating an angle and speed.
     * @param angle represent the angle
     * @param speed represent the speed
     * @return the velocity (Velocity)
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = Math.sin(Math.toRadians(angle)) * speed;
        double dy = Math.cos(Math.toRadians(angle)) * speed * -1;
        return new Velocity(dx, dy);
    }

    // Return dx

    /**
     * Retrunt the dx.
     * @return dx (double)
     */
    public double getDx() {
        return dx;
    }
    /**
     * Retrunt the dy.
     * @return dy (double)
     */
    public double getDy() {
        return dy;
    }
    /**
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     * @param p represent the center point of the ball
     * @return the new point (Point)
     */
    public Point applyToPoint(Point p) {
        p = new Point(this.dx + p.getX(), this.dy + p.getY());
        return p;
    }



}