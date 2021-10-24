//208384420

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.ArrayList;

/**
 * This class initialise and run the game.
 * each game has a sprite collection, game environment and gui.
 * The class contains the following functions:
 * A function that initialise all the objects in the game.
 * A function that run the game.
 * functions that return details of the ball.
 *
 * @author Yahel Jacoby
 */

public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter counterBlocks;
    private Counter counterBalls;
    private Counter counterScore;
    private biuoop.KeyboardSensor keyboard;
    private AnimationRunner runner;
    private boolean running;
    private LevelInformation levelInformation;
    private Counter counterLives;


    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HIGHT = 600;
    private static final int PADDLE_HIGHT = 15;
    private static final int SCREEN_BLOCKS_HIGHT = 15;
    private static final int START = 0;

    /**
     * This function is the constructor.
     * @param levelInformation the level
     * @param animationRunner the runner how run the animation
     * @param gui the GUI
     * @param live how many lives
     * @param score the current score
     */
    public GameLevel(LevelInformation levelInformation, int score, int live, AnimationRunner animationRunner, GUI gui) {
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.gui = gui;
        this.counterBlocks = new Counter(0);
        this.counterBalls = new Counter(0);
        this.counterScore = new Counter(score);
        this.keyboard = gui.getKeyboardSensor();
        this.running = false;
        this.runner = animationRunner;
        this.levelInformation = levelInformation;
        this.counterLives = new Counter(live);

    }

    /**
     * Add collidable object to the coliidable list.
     *
     * @param c the collidable object
     */

    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);

    }

    /**
     * Add sprite object to the sprite list.
     *
     * @param s the sprite object
     */

    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * return the game environment of the game.
     *
     * @return the game environment
     */

    public GameEnvironment getEnvironment() {
        return environment;
    }

    /**
     * Return the sprite collection of the game.
     *
     * @return the sprite collection
     */
    public SpriteCollection getSprite() {
        return this.sprites;
    }

    /**
     * get the level name.
     * @return the level name
     */
    public String getLevelName() {
        return levelInformation.levelName();
    }

    /**
     * get the score.
     * @return the score
     */
    public Counter getCounterScore() {
        return counterScore;
    }

    /**
     * Initialize a new game: create the Blocks and two Balls (and Paddle) and add them to the game.
     */

    public void initialize() {

        //initialise the paddle
        sprites.addSprite(levelInformation.getBackground());
        java.util.List<Ball> ballList = new ArrayList<>();
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            Ball ball1 = new Ball(new Point(400, 550), 7, Color.BLACK);
            ball1.setGameEnvironment(environment);
            ball1.addToGame(this);
            ball1.setVelocity(levelInformation.initialBallVelocities().get(i));
            ballList.add(ball1);
        }


        Rectangle forPaddle = new Rectangle(new Point(SCREEN_WIDTH / 2 - levelInformation.paddleWidth() / 2, 575),
                levelInformation.paddleWidth(), PADDLE_HIGHT);
        Paddle paddle = new Paddle(forPaddle, this.keyboard, this, 10);
        forPaddle.changeColor(new Color(0x99004C));
        paddle.addToGame(this);
        counterBalls.increase(ballList.size());
        BallRemover ballRemover = new BallRemover(this, counterBalls);
        for (Ball i : ballList) {
            i.addHitListener(ballRemover);
        }


        java.util.List<Block> blockList = new ArrayList<>();
        for (int i = 0; i < levelInformation.blocks().size(); i++) {
            blockList.add(levelInformation.blocks().get(i));
        }
        this.counterBlocks.increase(blockList.size());

        BlockRemover blockRemover = new BlockRemover(this, counterBlocks);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this);

        for (int i = 0; i < blockList.size(); i++) {
            blockList.get(i).addToGame(this);
            blockList.get(i).addHitListener(blockRemover);
            blockList.get(i).addHitListener(scoreTrackingListener);
        }

        Rectangle upperScreenR = new Rectangle(new Point(START, START + SCREEN_BLOCKS_HIGHT), SCREEN_WIDTH,
                SCREEN_BLOCKS_HIGHT);
        upperScreenR.changeFrameColor(new Color(224, 224, 224));
        Block upperScreenB = new Block(upperScreenR);
        Rectangle leftScreenR = new Rectangle(new Point(START, START), SCREEN_BLOCKS_HIGHT, SCREEN_HIGHT);
        leftScreenR.changeFrameColor(new Color(224, 224, 224));
        Block leftScreenB = new Block(leftScreenR);
        Rectangle rightScreenR = new Rectangle(new Point(SCREEN_WIDTH - SCREEN_BLOCKS_HIGHT, START),
                SCREEN_BLOCKS_HIGHT, SCREEN_HIGHT);
        rightScreenR.changeFrameColor(new Color(224, 224, 224));
        Block rightScreenB = new Block(rightScreenR);
        Block buttomScreen = new Block(new Rectangle(new Point(START, SCREEN_HIGHT),
                SCREEN_WIDTH, SCREEN_BLOCKS_HIGHT));
        Rectangle scoreR = new Rectangle(new Point(START, START), SCREEN_WIDTH, SCREEN_BLOCKS_HIGHT);
        scoreR.changeFrameColor(Color.gray);
        scoreR.changeColor(Color.gray);
        Block scoreBlock = new Block(scoreR);

        rightScreenB.addToGame(this);
        leftScreenB.addToGame(this);
        scoreBlock.addToGame(this);
        upperScreenB.addToGame(this);
        buttomScreen.addHitListener(ballRemover);
        buttomScreen.addToGame(this);

        sprites.addSprite(scoreTrackingListener);


    }
@Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.counterBlocks.getValue() == 0) {
            counterScore.increase(100);
            running = false;
            return;
        }
        if (this.counterBalls.getValue() == 0) {
            counterLives.decrease(1);
            java.util.List<Ball> ballList = new ArrayList<>();
            for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
                Ball ball1 = new Ball(new Point(400, 500), 7, Color.BLACK);
                ball1.setGameEnvironment(environment);
                ball1.addToGame(this);
                ball1.setVelocity(levelInformation.initialBallVelocities().get(i));
                ballList.add(ball1);
            }
            counterBalls.increase(ballList.size());
            return;
        }
        if (counterLives.getValue() == 0) {
            this.runner.run(new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY,
                    new EndOfGameScreen(counterScore.getValue())));
            gui.close();
            return;
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }

    }
    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {

        this.runner.run(new CountdownAnimation(2, 3, getSprite()));
        this.running = true;
        this.runner.run(this);
    }

    /**
     * return the blocks counter.
     * @return the blocks counter
     */
    public Counter getCounterBlocks() {
        return counterBlocks;
    }

    /**
     * return the balls counter.
     * @return the balls counter
     */
    public Counter getCounterBalls() {
        return counterBalls;
    }

    /**
     * remove collidable object to the coliidable list.
     *
     * @param c the collidable object
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * remove sprite object to the sprite list.
     *
     * @param s the sprite object
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);

    }

    /**
     * return the current lives.
     * @return the current lives
     */
    public Counter getCounterLives() {
        return counterLives;
    }

    /**
     * increase the score.
     * @param num how many to increase
     */
    public void increasScore(int num) {
        counterScore.increase(num);
    }

}