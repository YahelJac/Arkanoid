//208384420

/**
 * This class define the point object.
 * A point has an x, and y.
 * The class contain a function to measure the distance between two points.
 * also, contain a function to check if there are two points that are equals.
 *
 * @author Yahel Jacoby
 */
public class Point {

    private double x;
    private double y;
    private static final double EPSILON = Math.pow(10, -2);

    /**
     * This function is the constructor.
     *
     * @param x represent the x on the number line
     * @param y represent the y on the number line
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculate the distance between two points.
     *
     * @param other represent the other point
     * @return the distance (double)
     */
    public double distance(Point other) {
        //Formula for calculating distance between 2 points
        double temp = (((this.x - other.x) * (this.x - other.x)) + ((this.y - other.y) * (this.y - other.y)));
        //Return the distance
        return Math.sqrt(temp);
    }

    /**
     * Check if two points are equals.
     *
     * @param other represent the other point
     * @return true if the points are equals or false if not
     */
    public boolean equals(Point other) {
        if (Math.abs(this.x - other.x) <= EPSILON && Math.abs(this.y - other.y) <= EPSILON) {
            return true;
        }
        return false;
    }


    /**
     * Return the x of the point.
     *
     * @return x (double)
     */
    public double getX() {
        return this.x;
    }
    // Return the y values of this point

    /**
     * Return the y of the point.
     *
     * @return y (double)
     */
    public double getY() {
        return this.y;
    }
}