//208384420

import biuoop.DrawSurface;

import java.util.ArrayList;

/**
 * This class define the paddle object.
 * each paddle has a rectangle , key board sensor and game.
 * the class implements the collidable and sprite interface.
 * The class contains the following functions:
 * A functions that move the paddle.
 * A function that cuts the upper line of the puddle to 5 parts.
 * A function that check if the paddle run over the ball.
 * A function that draw the paddle.
 * A function that return a new velocity when the ball hit the paddle.
 *
 * @author Yahel Jacoby
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private java.util.List<Point> fiveParts;
    private static final double EPSILON = Math.pow(10, -2);
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HIGHT = 600;
    private static final int MOVE_STEP = 5;
    private static final int LEFT_ANGLE = 300;
    private static final int SIX_POINTS = 6;
    private GameLevel gameLevel;
    private int speed;

    /**
     * This function is the constructor.
     *
     * @param rectangle the rectangle of the paddle
     * @param keyboard  the ket board sensor
     * @param gameLevel the game that the paddle is into
     * @param speed the paddle speed
     */
    public Paddle(Rectangle rectangle, biuoop.KeyboardSensor keyboard, GameLevel gameLevel, int speed) {
        this.rectangle = rectangle;
        this.fiveParts = cutTheTopLine(rectangle.getTopLine());
        this.keyboard = keyboard;
        this.gameLevel = gameLevel;
        this.speed = speed;

    }

    /**
     * move the paddle left.
     */
    public void moveLeft() {
        Rectangle temp = new Rectangle(new Point(rectangle.getUpperLeft().getX() - this.speed,
                rectangle.getUpperLeft().getY()), rectangle.getWidth(), rectangle.getHeight());
        temp.changeColor(this.rectangle.getColor());
        this.rectangle = temp;
        this.fiveParts = cutTheTopLine(rectangle.getTopLine());

    }

    /**
     * move the paddle right.
     */
    public void moveRight() {
        Rectangle temp = new Rectangle(new Point(rectangle.getUpperLeft().getX() + this.speed,
                rectangle.getUpperLeft().getY()), rectangle.getWidth(), rectangle.getHeight());
        temp.changeColor(this.rectangle.getColor());
        this.rectangle = temp;
        this.fiveParts = cutTheTopLine(rectangle.getTopLine());
    }

    /**
     * cut the top line to 5 part.
     *
     * @param topLine the top line of the rectangle
     * @return the point list
     */
    public java.util.List<Point> cutTheTopLine(Line topLine) {
        java.util.List<Point> pointList = new ArrayList<>();
        double spaceBetweenTwoParts = (topLine.end().getX() - topLine.start().getX()) / 5;
        for (int i = 0; i < SIX_POINTS; i++) {
            Point point = new Point(i * spaceBetweenTwoParts + topLine.start().getX(), topLine.start().getY());
            pointList.add(point);
        }
        return pointList;
    }

    /**
     * check if the paddle run over the ball.
     *
     * @return boolean
     */
    public boolean doNotMove() {
        for (int i = 0; i < gameLevel.getSprite().getSpriteCollection().size(); i++) {
            if (gameLevel.getSprite().getSpriteCollection().get(i).getClass().getName() == "Ball") {
                Ball temp = (Ball) gameLevel.getSprite().getSpriteCollection().get(i);
                if (rectangle.isItInRectangle(temp.getCenter())) {
                    return true;
                }
            }
            ;
        }
        return false;
    }

    /**
     * check if the keyboard is pressed on the left or right key, if do call to the right function.
     */
    public void timePassed() {


        if (keyboard.isPressed(keyboard.LEFT_KEY) || this.rectangle.getUpperRight().getX() >= SCREEN_WIDTH - 10) {
            this.moveLeft();
            if (doNotMove()) {
                this.moveRight();
            }
        }
        if (keyboard.isPressed(keyboard.RIGHT_KEY) || this.rectangle.getUpperLeft().getX() <= 10) {
            this.moveRight();
            if (doNotMove()) {
                this.moveLeft();
            }
        }

    }

    /**
     * draw the paddle.
     *
     * @param d the surface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.rectangle.getColor());
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }

    /**
     * get the rectangle of the paddle.
     *
     * @return rectangle
     */
    public Rectangle getCollisionRectangle() {
        return rectangle;
    }

    /**
     * calculate the new velocity after the hit.
     *
     * @param collisionPoint  the point of the collision
     * @param currentVelocity the ole velocity
     * @param hitter          the ball how hit
     * @return the new velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (Math.abs(collisionPoint.getY() - this.rectangle.getUpperLeft().getY()) < EPSILON) {

            for (int i = 0; i < SIX_POINTS; i++) {
                if (i == 2) {
                    continue;
                }
                if (collisionPoint.getX() >= this.fiveParts.get(i).getX() && collisionPoint.getX()
                        <= this.fiveParts.get(i + 1).getX()) {
                    double currentSpeed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
                            + Math.pow(currentVelocity.getDy(), 2));
                    currentVelocity = Velocity.fromAngleAndSpeed(LEFT_ANGLE + i * 30, currentSpeed);
                    return currentVelocity;
                }
            }
            currentVelocity = new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
            return currentVelocity;


        }

        if (Math.abs(collisionPoint.getX() - this.rectangle.getBottomRight().getX()) < EPSILON
                || Math.abs(collisionPoint.getX() - this.rectangle.getUpperLeft().getX()) < EPSILON) {
            currentVelocity = new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
        }
        if (Math.abs(collisionPoint.getY() - this.rectangle.getBottomRight().getY()) < EPSILON
                || Math.abs(collisionPoint.getY() - this.rectangle.getUpperLeft().getY()) < EPSILON) {
            currentVelocity = new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
        }
        return currentVelocity;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}