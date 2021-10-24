//208384420

import java.awt.Color;
import java.util.ArrayList;

/**
 * This class define the rectangle object.
 * each rectangle has a upper left point, width and height.
 * in addition to that, each rectangle has all 4 points, color, and all his lines.
 * The class contains the following functions:
 * A function that find a intersection points with a line and return a array of those points.
 * A function that check if a certain point is inside the rectangle.
 * A functions that change the color of the rectangle.
 * Besides them, there are functions that return us details about the rectangle (upper left point, width, height)
 *
 * @author Yahel Jacoby
 */
public class Rectangle {
    private double width;
    private double height;
    private Point upperLeft;
    private Point upperRight;
    private Point bottomRight;
    private Point bottomLeft;
    private Line topLine;
    private Line leftLine;
    private Line rightLine;
    private Line bottomLine;
    private Color color;
    private Color frame;

    /**
     * This function is the constructor.
     *
     * @param upperLeft represent the upper left point of the rectangle
     * @param width     represent the width of the rectangle
     * @param height    represent the height of the rectangle
     *                  <p>
     *                  all the other variables are to make the program easier.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.height = height;
        this.width = width;
        this.upperLeft = upperLeft;
        this.upperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        this.bottomRight = new Point(upperRight.getX(), upperRight.getY() + height);
        this.bottomLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
        this.topLine = new Line(upperLeft, upperRight);
        this.leftLine = new Line(upperLeft, bottomLeft);
        this.rightLine = new Line(upperRight, bottomRight);
        this.bottomLine = new Line(bottomLeft, bottomRight);
        this.color = new Color(224, 224, 224);
        this.frame = Color.BLACK;

    }

    /**
     * Return a (possibly empty) List of intersection points with the specified line.
     *
     * @param line specific line
     * @return a list of the intersection points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        java.util.List<Point> l1 = new ArrayList<>();


        if (line.isIntersecting(topLine)) {
            l1.add(line.intersectionWith(topLine));
        }
        if (line.isIntersecting(leftLine)) {
            l1.add(line.intersectionWith(leftLine));
        }
        if (line.isIntersecting(rightLine)) {
            Point tempP = line.intersectionWith(rightLine);
            l1.add(tempP);
        }
        if (line.isIntersecting(bottomLine)) {
            l1.add(line.intersectionWith(bottomLine));
        }

        return l1;

    }

    /**
     * Return the width of the rectangle.
     *
     * @return width
     */

    //
    public double getWidth() {
        return width;
    }

    /**
     * Return the height of the rectangle.
     *
     * @return height
     */

    public double getHeight() {
        return height;
    }

    /**
     * Returns the upper-right point of the rectangle.
     *
     * @return upper-right point
     */

    public Point getUpperRight() {
        return upperRight;
    }

    /**
     * Returns the upper-left point of the rectangle.
     *
     * @return upper-left point
     */

    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * Returns the Bottom-right point of the rectangle.
     *
     * @return Bottom-right point
     */

    public Point getBottomRight() {
        return bottomRight;
    }

    /**
     * Returns the Bottom-right point of the rectangle.
     *
     * @return Bottom-right point
     */

    public Point getBottomLeft() {
        return bottomLeft;
    }

    /**
     * Returns the top line of the rectangle.
     *
     * @return top line
     */

    public Line getTopLine() {
        return topLine;
    }

    /**
     * Returns the color of the rectangle.
     *
     * @return the color
     */

    public Color getColor() {
        return color;
    }

    /**
     * Check if a certain point is inside the rectangle.
     *
     * @param point represent a certain point
     * @return boolean result.
     */
    public boolean isItInRectangle(Point point) {
        if (point.getX() >= upperLeft.getX() && point.getX() <= upperRight.getX()
                && point.getY() >= upperLeft.getY() && point.getY() <= bottomLeft.getY()) {
            return true;
        }
        return false;
    }

    /**
     * Change the color of the rectangle.
     *
     * @param newColor represent the chosen color
     */
    public void changeColor(Color newColor) {
        this.color = newColor;
    }

    /**
     * change the frame color.
     *
     * @param newColor change to this color
     */
    public void changeFrameColor(Color newColor) {
        this.frame = newColor;
    }

    /**
     * return the frame color.
     *
     * @return frame color
     */
    public Color getFrame() {
        return frame;
    }
}