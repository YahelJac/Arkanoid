//208384420
/**
 * the counter class responsible on count scour, how many balls or blocks in the game, or in the future
 * more object that we will want to count.
 */
public class Counter {

    private int counter;

    /**
     * this is the constructor.
     * @param counter the first number that we start counting from.
     */
    public Counter(int counter) {
        this.counter = counter;
    }

    /**
     * add number to current count.
     * @param number how match to add
     */
    public void increase(int number) {
        this.counter = this.counter + number;
    }

    /**
     * subtract number from current count.
     * @param number how match to decrease
     */
    public void decrease(int number) {
        this.counter = this.counter - number;
    }

    /**
     * get current count.
     * @return the counter
     */
    public int getValue() {
        return counter;
    }
}
