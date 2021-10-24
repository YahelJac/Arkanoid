//208384420
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * this class is the Rainbow level.
 */
public class Rainbow implements LevelInformation {


    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(Velocity.fromAngleAndSpeed(-45, 8));
        velocityList.add(Velocity.fromAngleAndSpeed(45, 8));
        velocityList.add(Velocity.fromAngleAndSpeed(0, 8));


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
        return new String("Rainbow");
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
            Rectangle temp = new Rectangle(new Point(i, 100), 60, 20);
            temp.changeColor(new Color(255, 153, 153));
            Block tempBlock = new Block(temp);
            blockList.add(tempBlock);

        }
        for (int i = 10; i < 790; i = i + 60) {
            Rectangle temp = new Rectangle(new Point(i, 120), 60, 20);
            temp.changeColor(new Color(255, 204, 153));
            Block tempBlock = new Block(temp);
            blockList.add(tempBlock);

        }
        for (int i = 10; i < 790; i = i + 60) {
            Rectangle temp = new Rectangle(new Point(i, 140), 60, 20);
            temp.changeColor(new Color(255, 255, 153));
            Block tempBlock = new Block(temp);
            blockList.add(tempBlock);

        }
        for (int i = 10; i < 790; i = i + 60) {
            Rectangle temp = new Rectangle(new Point(i, 160), 60, 20);
            temp.changeColor(new Color(153, 255, 204));
            Block tempBlock = new Block(temp);
            blockList.add(tempBlock);

        }
        for (int i = 10; i < 790; i = i + 60) {
            Rectangle temp = new Rectangle(new Point(i, 180), 60, 20);
            temp.changeColor(new Color(153, 204, 255));
            Block tempBlock = new Block(temp);
            blockList.add(tempBlock);

        }

        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 65;
    }

    @Override
    public void creatBackGround(DrawSurface d) {
        d.setColor(new Color(164, 255, 255));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(new Color(144, 39, 60));
        d.fillCircle(50, 600, 200);
        d.setColor(new Color(255, 112, 56));
        d.fillCircle(50, 600, 180);
        d.setColor(new Color(236, 197, 0));
        d.fillCircle(50, 600, 160);
        d.setColor(new Color(107, 205, 63));
        d.fillCircle(50, 600, 140);
        d.setColor(new Color(39, 144, 114));
        d.fillCircle(50, 600, 120);
        d.setColor(new Color(45, 164, 194));
        d.fillCircle(50, 600, 100);
        d.setColor(new Color(19, 26, 170));
        d.fillCircle(50, 600, 80);
        d.setColor(new Color(79, 39, 144));
        d.fillCircle(50, 600, 60);
        d.setColor(new Color(164, 255, 255));
        d.fillCircle(50, 600, 40);
        d.setColor(new Color(224, 224, 224));
        for (int i = 135; i < 250; i = i + 10) {
            d.drawLine(i, 300, i - 15, 600);
        }
        for (int i = 535; i < 640; i = i + 10) {
            d.drawLine(i, 400, i - 15, 600);
        }
        d.fillCircle(150, 300, 30);
        d.fillCircle(550, 400, 30);
        d.setColor(new Color(224, 224, 224));
        d.fillCircle(170, 310, 35);
        d.fillCircle(570, 410, 35);
        d.setColor(new Color(215, 215, 215));
        d.fillCircle(230, 310, 40);
        d.fillCircle(620, 410, 40);
        d.setColor(new Color(203, 203, 203));
        d.fillCircle(190, 300, 30);
        d.fillCircle(590, 400, 30);
        d.setColor(new Color(217, 215, 215));
        d.fillCircle(210, 320, 25);
        d.fillCircle(600, 410, 25);


    }


}