//208384420
import biuoop.DrawSurface;

/**
 * An interface for animation.
 */
public interface Animation {
    /**
     * function that creat one frame.
     * @param d the surface
     */
    void doOneFrame(DrawSurface d);

    /**
     * determine if the frame is done.
     * @return true or false
     */
    boolean shouldStop();
}