//208384420

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * this class is the KingKong level.
 */
public class KingKong implements LevelInformation {


    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocityList = new ArrayList<>();
        velocityList.add(Velocity.fromAngleAndSpeed(-35, 8));
        velocityList.add(Velocity.fromAngleAndSpeed(35, 8));


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
        return new String("KingKong");
    }

    @Override
    public Sprite getBackground() {
        BackGround backGround = new BackGround(this);
        return backGround;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        for (int i = 190; i < 790; i = i + 60) {
            Rectangle temp = new Rectangle(new Point(i, 100), 60, 20);
            temp.changeColor(new Color(255, 153, 153));
            Block tempBlock = new Block(temp);
            blockList.add(tempBlock);

        }
        for (int i = 190; i < 790; i = i + 60) {
            Rectangle temp = new Rectangle(new Point(i, 100), 60, 20);
            temp.changeColor(new Color(255, 153, 153));
            Block tempBlock = new Block(temp);
            blockList.add(tempBlock);

        }
        for (int i = 250; i < 790; i = i + 60) {
            Rectangle temp = new Rectangle(new Point(i, 120), 60, 20);
            temp.changeColor(new Color(255, 204, 153));
            Block tempBlock = new Block(temp);
            blockList.add(tempBlock);

        }
        for (int i = 310; i < 790; i = i + 60) {
            Rectangle temp = new Rectangle(new Point(i, 140), 60, 20);
            temp.changeColor(new Color(255, 255, 153));
            Block tempBlock = new Block(temp);
            blockList.add(tempBlock);

        }
        for (int i = 370; i < 790; i = i + 60) {
            Rectangle temp = new Rectangle(new Point(i, 160), 60, 20);
            temp.changeColor(new Color(204, 255, 153));
            Block tempBlock = new Block(temp);
            blockList.add(tempBlock);

        }
        for (int i = 430; i < 790; i = i + 60) {
            Rectangle temp = new Rectangle(new Point(i, 180), 60, 20);
            temp.changeColor(new Color(153, 255, 153));
            Block tempBlock = new Block(temp);
            blockList.add(tempBlock);

        }

        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 34;
    }

    @Override
    public void creatBackGround(DrawSurface d) {
        d.setColor(new Color(209, 248, 248));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(new Color(102, 255, 178));
        d.fillRectangle(100, 300, 150, 300);
        d.setColor(new Color(54, 156, 106));
        d.fillRectangle(163, 250, 20, 50);
        d.setColor(new Color(40, 120, 84));
        d.fillRectangle(170, 200, 5, 50);
        d.setColor(Color.WHITE);

        for (int i = 106; i < 240; i = i + 20) {
            for (int j = 310; j < 600; j = j + 15) {
                d.fillRectangle(i, j, 15, 10);
            }
        }

        d.setColor(new Color(255, 178, 102));
        d.fillCircle(172, 200, 10);
        d.setColor(new Color(255, 0, 0));
        d.fillCircle(172, 200, 7);
        d.setColor(new Color(255, 255, 170));
        d.fillCircle(172, 200, 4);


    }


}