//208384420

import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;

/**
 * this class is running the whole game.
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private GUI gui;
    private KeyboardSensor k;

    /**
     * this is the constructor.
     */
    public GameFlow() {
        this.gui = new GUI("game", 800, 600);
        this.animationRunner = new AnimationRunner(gui, 60);
        this.k = gui.getKeyboardSensor();
    }

    /**
     * this function runs the levels by the order in the list.
     * @param levels the list of levels
     */
    public void runLevels(List<LevelInformation> levels) {

        int score = 0;
        int live = 7;
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, score, live, animationRunner, gui);

            level.initialize();

            while (level.getCounterBlocks().getValue() != 0 && level.getCounterBalls().getValue() != 0) {
                level.run();
            }
            score = level.getCounterScore().getValue();
            live = level.getCounterLives().getValue();
            if (level.getCounterBalls().getValue() == 0) {

                break;
            }

        }
        animationRunner.run(new KeyPressStoppableAnimation(k, KeyboardSensor.SPACE_KEY, new WinScreen(score)));
        gui.close();

    }
}