//208384420

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * this class responsible on stopping the screen when pressing a key.
 */
public class KeyPressStoppableAnimation implements Animation {

    private boolean isAlreadyPressed;
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean stop;

    /**
     * this is the constructor.
     * @param sensor the key sensor
     * @param key the key
     * @param animation the animation that need to be stopped
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (!this.sensor.isPressed(key)) {
            isAlreadyPressed = false;
        }
        animation.doOneFrame(d);
        if (this.sensor.isPressed(key) && !isAlreadyPressed) {
            this.stop = true;
        }

    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

}
