//208384420


import biuoop.DrawSurface;

/**
 * This class define the line object.
 * A line has a start point and an end point.
 * The class contains the following functions:
 * A function that returns the middle point of a line.
 * A function that returns if two lines are intersecting.
 * A function that returns the intersection point.
 * and a function that check if two lines are the same.
 * Besides them, there are functions that help to execute the main functions
 *
 * @author Yahel Jacoby
 */

public class Line implements Sprite {
    private Point start;
    private Point end;
    private static final double EPSILON = Math.pow(10, -10);

    /**
     * This function is the constructor.
     *
     * @param start represent the first edge of the line
     * @param end   represent the second edge of the line
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * This function is the constructor, only this time its create the point inside the constructor.
     *
     * @param x1 represent the x of the first point
     * @param y1 represent the y of the first point
     * @param x2 represent the x of the second point
     * @param y2 represent the y of the second point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Return the length of the line by using the function in class point.
     *
     * @return the length of the line
     */
    public double length() {
        return end().distance(this.start);
    }

    /**
     * Calculate the middle point of the line.
     *
     * @return the middle point (Point)
     */
    public Point middle() {
        double middleX = (start.getX() + end.getX()) / 2;
        double middleY = (start.getY() + end.getY()) / 2;
        return new Point(middleX, middleY);
    }

    /**
     * Returns the start point of the line.
     *
     * @return start point (Point)
     */
    public Point start() {
        return this.start;
    }

    /**
     * Returns the end point of the line.
     *
     * @return end point (Point)
     */
    public Point end() {
        return this.end;
    }

    /**
     * Return the slope of line.
     *
     * @param line represent the other line
     * @return the slop 'm' (double)
     */
    public double slops(Line line) {
        double m = (line.start.getY() - line.end.getY()) / (line.start.getX() - line.end.getX());
        if (line.start.getX() == line.end.getX()) {
            return Math.abs(m);
        }
        return m;
    }

    /**
     * Return n (y=mx+n).
     *
     * @param other represent the other line
     * @param m     represent the slop
     * @return n (y=mx+*n*, double)
     */
    public double n(Line other, double m) {
        double n = other.start.getY() - m * other.start.getX();
        return n;
    }

    /**
     * Return the intersection point by using a formula.
     *
     * @param n1 represent the n of the first line
     * @param n2 represent the n of the second line
     * @param m1 represent the m of the first line
     * @param m2 represent the m of the second line
     * @return the intersection point (Point)
     */
    public Point intersectingPoint(double n1, double n2, double m1, double m2) {
        if (n1 == 0 && m1 == 0) {
            return (new Point(-1 * n2 / m2, 0));
        }
        if (n2 == 0 && m2 == 0) {
            return (new Point(-1 * n1 / m1, 0));
        }

        double newX = (n2 - n1) / (m1 - m2);
        double newY = m1 * newX + n1;
        return new Point(newX, newY);

    }

    /**
     * Check all the cases when two lines with the same slope.
     *
     * @param other represent the other line
     * @return true if the lines has the same slop
     */
    public boolean lineWithSameSloop(Line other) {
        //If they are equals
        if (this.start.equals(other.start) && this.start.equals(this.end) && this.start.equals(other.end)) {
            return true;
        }
        if (this.equals(other)) {
            return false;
        }

        //If the two lines have common start or end points, checks if the lines overlap or not
        if (this.start.equals(other.start) && ((this.length() + other.length()) - new Line(this.end, other.end).length()
                < EPSILON)) {
            return true;
        }

        if (this.end.equals(other.start) && ((this.length() + other.length()) - new Line(this.start, other.end).length()
                < EPSILON)) {
            return true;
        }
        if (this.start.equals(other.end) && ((this.length() + other.length()) - new Line(this.end, other.start).length()
                < EPSILON)) {
            return true;
        }

        if (this.end.equals(other.end) && ((this.length() + other.length()) - new Line(this.start, other.start).length()
                < EPSILON)) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the lines do continue to the intersection point.
     *
     * @param newPoint represent the intersection point
     * @param other    represent the other line
     * @return false if the intersection point is not in the range of the line, true otherwise
     */
    public boolean isLongEnough(Point newPoint, Line other) {
        if (newPoint.getX() - EPSILON > Math.max(this.end.getX(), this.start.getX())
                || newPoint.getX() - EPSILON > Math.max(other.start.getX(), other.end.getX())) {
            return false;
        }
        if (newPoint.getX() + EPSILON < Math.min(this.end.getX(), this.start.getX())
                || newPoint.getX() + EPSILON < Math.min(other.start.getX(), other.end.getX())) {
            return false;
        }
        if (newPoint.getY() - EPSILON > Math.max(this.end.getY(), this.start.getY())
                || newPoint.getY() - EPSILON > Math.max(other.start.getY(), other.end.getY())) {
            return false;
        }
        if (newPoint.getY() + EPSILON < Math.min(this.end.getY(), this.start.getY())
                || newPoint.getY() + EPSILON < Math.min(other.start.getY(), other.end.getY())) {
            return false;
        }
        return true;
    }

    /**
     * Function that check if two lines are intersecting.
     *
     * @param other represent the other line
     * @return true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        //Special case - if the two lines are vertical
        if (other.start.getX() == other.end.getX() && this.start.getX() == this.end.getX()) {
            return lineWithSameSloop(other);
        } else {
            double m1 = slops(this);
            double m2 = slops(other);
            if (m1 == m2) {
                return lineWithSameSloop(other);
            }
        }
        //Special case - if one of lines is vertical
        if (other.start.getX() == other.end.getX() && this.start.getX() != this.end.getX()) {
            return isLongEnough(spacialCase(other), other);
        }
        //Special case - if one of lines is vertical
        if (other.start.getX() != other.end.getX() && this.start.getX() == this.end.getX()) {
            return isLongEnough(spacialCase(other), other);
        } else {
            double m1 = slops(new Line(start, end));
            double m2 = slops(other);
            double n1 = n(new Line(start, end), m1);
            double n2 = n(other, m2);
            Point newPoint = intersectingPoint(n1, n2, m1, m2);
            // Check if the lines do continue to the intersection point
            return isLongEnough(newPoint, other);

        }
    }

    /**
     * This function treat a special case that one of the lines is vertical.
     *
     * @param other represent the other line
     * @return the intersecting point
     */
    public Point spacialCase(Line other) {
        if (other.start.getX() == other.end.getX() && this.start.getX() != this.end.getX()) {
            double m1 = slops(this);
            double n1 = n(this, m1);
            return new Point(other.start.getX(), m1 * other.start.getX() + n1);

        }
        double m1 = slops(other);
        double n1 = n(other, m1);
        return new Point(this.start.getX(), m1 * this.start.getX() + n1);


    }

    /**
     * Function that calculate the intersection point.
     *
     * @param other represent the other line
     * @return the intersection point if the lines intersect,and null otherwise
     */
    public Point intersectionWith(Line other) {
        //Check if the there is a Intersection point
        if (!isIntersecting(other)) {
            return null;
        } else {
            if (this.start.equals(other.start) && this.start.equals(this.end) && this.start.equals(other.end)) {
                return this.start;
            }
            double m1 = slops(new Line(start, end));
            double m2 = slops(other);
            if (m1 == m2) {
                if (this.start.equals(other.start)) {
                    return this.start;
                }

                if (this.end.equals(other.start)) {
                    return this.end;
                }
                if (this.start.equals(other.end)) {
                    return this.start;
                }

                if (this.end.equals(other.end)) {
                    return this.end;
                }
            }

            if (other.start.getX() == other.end.getX() && this.start.getX() != this.end.getX()) {
                return spacialCase(other);
            }
            //Special case - if one of lines is vertical
            if (other.start.getX() != other.end.getX() && this.start.getX() == this.end.getX()) {
                return spacialCase(other);
            }
            double n1 = n(new Line(start, end), m1);
            double n2 = n(other, m2);
            // Calling to a function that responsible for the calculations
            return intersectingPoint(n1, n2, m1, m2);
        }

    }

    /**
     * Function that check if two lines are equals.
     *
     * @param other represent the line
     * @return true if the lines are equals, false otherwise
     */
    public boolean equals(Line other) {
        if (this.start.equals(other.start) && this.end.equals(other.end)) {
            return true;
        }
        if (this.start.equals(other.end) && this.end.equals(other.start)) {
            return true;
        }
        return false;
    }

    /**
     * check what is the closest intersection from a list of points.
     *
     * @param rect the rectangle
     * @return the closest point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {

        java.util.List<Point> l1 = rect.intersectionPoints(new Line(this.start, this.end));

        if (l1 == null || l1.size() == 0) {
            return null;
        }
        Point closest = l1.get(0);
        for (int i = 0; i < l1.size(); i++) {
            if (closest.distance(this.start) > l1.get(i).distance(this.start)) {
                closest = l1.get(i);
            }
        }
        return closest;


    }

    @Override
    public void drawOn(DrawSurface d) {
        d.drawLine((int) start.getX(), (int) start.getY(), (int) end.getX(), (int) end.getY());
    }

    @Override
    public void timePassed() {

    }
}

