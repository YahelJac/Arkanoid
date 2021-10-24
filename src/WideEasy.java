//208384420

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * this class is the WideEasy level.
 */
public class WideEasy implements LevelInformation {


    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        for (int i = -50; i <= -10; i = i + 10) {
            velocityList.add(Velocity.fromAngleAndSpeed(i, 8));
        }
        for (int i = 10; i < 60; i = i + 10) {
            velocityList.add(Velocity.fromAngleAndSpeed(i, 8));
        }

        return velocityList;
    }

    @Override
    public int paddleSpeed() {
        return 10;
    }

    @Override
    public int paddleWidth() {
        return 410;
    }

    @Override
    public String levelName() {
        return new String("WideEasy");
    }

    @Override
    public Sprite getBackground() {
        BackGround backGround = new BackGround(this);
        return backGround;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        for (int i = 10; i < 790; i = i + 60) {
            blockList.add(new Block(new Rectangle(new Point(i, 220), 60, 20)));
        }


        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 16;
    }

    @Override
    public void creatBackGround(DrawSurface d) {

        d.setColor(new Color(209, 248, 248));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(new Color(255, 255, 153));
        for (int i = 0; i < 800; i = i + 30) {
            d.drawLine(120, 120, i, 220);
        }
        d.fillCircle(120, 120, 70);
        d.setColor(new Color(255, 213, 63));
        d.fillCircle(120, 120, 60);
        d.setColor(new Color(255, 193, 59));
        d.fillCircle(120, 120, 50);
        d.setColor(new Color(255, 255, 153));


    }


}