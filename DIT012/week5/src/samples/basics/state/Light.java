package samples.basics.state;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;

/**
 * Logical light
 */
public class Light {

    public enum State {
        ON,
        OFF
    }

    private State state = State.OFF;
    private long totalUpTime = 0;
    private long time;

    // Return state to simplify
    public State update(int cmd) {
        if (cmd == 0) {
            state = State.OFF;
            totalUpTime += (currentTimeMillis() - time);
        } else if (cmd == 1) {
            state = State.ON;
            time = currentTimeMillis();
        } else {
            throw new IllegalArgumentException("Bad cmd");
        }
        // Just for debug
        out.println("cmd " + cmd);
        return state;
    }

    public double getTotalUpTime() {
        return totalUpTime / 1000;
    }

    public State getState() {
        return state;
    }
}
