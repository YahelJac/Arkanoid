//208384420
import biuoop.DrawSurface;

/**
 * this class is calling the background function in every level. its implement Sprite.
 */
public class BackGround implements Sprite {
    private LevelInformation levelInformation;

    /**
     * this is the constructor.
     * @param level the level that need to br draw
     */
    public BackGround(LevelInformation level) {
        this.levelInformation = level;
    }


    @Override
    public void drawOn(DrawSurface d) {

        levelInformation.creatBackGround(d);
    }

    @Override
    public void timePassed() {

    }


}