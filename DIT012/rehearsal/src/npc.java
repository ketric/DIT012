import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by kenny on 2017-01-10.
 */
public class npc {
    private double x;
    private double y;
    private int health;
    private int power;

    public npc(double x, double y, int health, int power) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.power = power;
    }

    public npc( npc other) {
        x = other.x;
        y = other.y;
        health = other.health;
        power = other.power;
    }

    public boolean isDead(){
        return health == 0;
    }
}
