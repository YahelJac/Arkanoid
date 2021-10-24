//208384420
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the class of the level DirectHit.
 */
public class DirectHit implements LevelInformation {


    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(Velocity.fromAngleAndSpeed(0, 5));
        return velocityList;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 150;
    }

    @Override
    public String levelName() {
        return new String("DirectHit");
    }

    @Override
    public Sprite getBackground() {
        BackGround backGround = new BackGround(this);

        return backGround;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        Rectangle rectangle = new Rectangle(new Point(385, 200), 30, 30);
        rectangle.changeColor(new Color(255, 51, 51));
        blockList.add(new Block(rectangle));

        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }

    @Override
    public void creatBackGround(DrawSurface d) {

        d.drawText(700, 13, levelName(), 15);
        d.setColor(new Color(255, 229, 204));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.BLACK);
        d.drawLine(400, 115, 400, 315);
        d.drawLine(500, 215, 300, 215);
        d.drawCircle(400, 215, 90);
        d.drawCircle(400, 215, 70);
        d.drawCircle(400, 215, 50);


    }


}