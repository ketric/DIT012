package assignment.product;

import javax.activity.ActivityRequiredException;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.lang.System.out;

/*
 * A Simulation
 *
 * See : http://nifty.stanford.edu/2014/mccown-schelling-model-segregation/
 *
 */
// Extends JPanel because we will will draw graphics
public class Simulation2 extends JPanel {

    public static void main(String[] args) {
        new Simulation2().program();
    }

    // Enumeration (reference) type for the Actors
    enum Actor {
        BLUE, NONE, RED
    }

    // Enumeration (reference) type for the state of an Actor
    enum State {
        UNSATISFIED,
        NA,        // Not applicable (NA), used for NONEs
        SATISFIED
    }

    // Below are th only accepted instance variables
    final Random rand = new Random();
    // %-distribution of RED, BLUE and NONE
    // Result (terminating?) is very depending on % empty and threshold, experiment!
    final double[] distribution = {0.25, 0.25, 0.50};
    // % of surrounding neighbours that are like me
    final double threshold = 0.7; // 0.5 easier for testing;
    //  This is hard coded for testing purposes (later you should generate the world)
    Actor[][] world = {
            {Actor.RED, Actor.RED, Actor.NONE},
            {Actor.NONE, Actor.BLUE, Actor.NONE},  // Middle BLUE is dissatisfied (threshold = 0.5)
            {Actor.RED, Actor.NONE, Actor.BLUE}    // Left RED is dissatisfied (threshold = 0.5)
    };
    boolean toggle = true;  // Used in updateWorld
    State[][] state;   // Matrix for the state of all Actors

    void program() {
        generateWorld(30);
        plot(world);
        initGraphics();
        initEvents();
    }

    // Method called by timer
    void updateWorld() {
        if (toggle) {
            updateState();
        } else {
            moveUnsatisfied(addArrays(get(State.UNSATISFIED), get(State.NA)));
        }
        toggle = !toggle;
    }


    // ------- Write your method below this ---------------

    void updateState(){
        Actor[] actors = fromMatrix(world);
        State[] states = new State[fromMatrix(world).length];
        for (int i = 0; i < actors.length; i++){
            if (actors[i] != Actor.NONE){
                states[i] = checkNeighbours(actors, i);
            }
            else{
                states[i] = State.NA;
            }
        }
        state = toMatrix(states);
    }
    State checkNeighbours(Actor[] actors, int i) {
        int nNeighbours = 0;
        int nSameColour = 0;

        if (i > world.length) { // Might have neighbours above
            nNeighbours += isNeighbour(i - world.length, actors);
            nSameColour += areSameColour(i, i - world.length, actors);
            if (i % world.length < world.length - 1){ // Might have neighbours above to the right
                nNeighbours += isNeighbour(i - world.length + 1, actors);
                nSameColour += areSameColour(i, i - world.length + 1, actors);
            }
        }
        if (i % world.length < world.length - 1){ // Might have neighbours to the right
            nNeighbours += isNeighbour(i + 1, actors);
            nSameColour += areSameColour(i, i + 1, actors);
            if (i < actors.length - world.length){ // Might have neighbours below to the right
                nNeighbours += isNeighbour(i + world.length + 1, actors);
                nSameColour += areSameColour(i, i + world.length + 1, actors);
            }
        }
        if (i < actors.length - world.length){ // Might have neighbours below
            nNeighbours += isNeighbour(i + world.length, actors);
            nSameColour += areSameColour(i, i + world.length, actors);
            if (i % world.length > 0){ // Might have neighbours below to the left
                nNeighbours += isNeighbour(i + world.length- 1, actors);
                nSameColour += areSameColour(i, i + world.length - 1, actors);
            }
        }
        if (i % world.length > 0){ // Might have neighbours to the left
            nNeighbours += isNeighbour(i - 1, actors);
            nSameColour += areSameColour(i, i - 1, actors);
            if (i > world.length) { // Might have neighbours above to the left
                nNeighbours += isNeighbour(i - world.length - 1, actors);
                nSameColour += areSameColour(i, i - world.length - 1, actors);
            }
        }

        if ((double)(nSameColour)/(double)(nNeighbours) < threshold){
            return State.UNSATISFIED;
        }
        return State.SATISFIED;

    }
    int isNeighbour(int j, Actor[] actors){ // return type is integer because of usefulness
        if(actors[j] != Actor.NONE) {
            return 1;
        }
        return 0;
    }
    int areSameColour(int i, int j, Actor[] actors){ // return type is integer because of usefulness
        if(actors[j] == actors[i]){
            return 1;
        }
        return 0;
    }

    Actor[] fromMatrix( Actor[][] matrix){
        Actor[] arr = new Actor[matrix.length*matrix.length];
        for (int y = 0, n = 0; y < matrix.length; y++){
            for (int x = 0; x < matrix.length; x++){
                arr[n] = matrix[y][x];
                n++;
            }

        }
        return arr;
    }
    State[] fromMatrix( State[][] matrix){
        State[] arr = new State[matrix.length*matrix.length];
        for (int y = 0, n = 0; y < matrix.length; y++){
            for (int x = 0; x < matrix.length; x++){
                arr[n] = matrix[y][x];
                n++;
            }

        }
        return arr;
    }
    State[][] toMatrix(State[] arr) {
        int size = (int) round(sqrt(arr.length));
        State[][] matrix = new State[size][size];
        for (int i = 0; i < arr.length; i++) {
            matrix[i / size][i % size] = arr[i];
        }
        return matrix;
    }

    void generateWorld(int size){
        world = new Actor[size][size];
        int blues = nActors(distribution[0]);
        int reds = nActors(distribution[1]);

        for (int y = 0; y < world.length && blues > 0; y++){
            for (int x = 0; x < world.length && blues > 0; x++){
                world[y][x] = Actor.BLUE;
                blues--;
            }
        }

        for (int y = world.length - 1; y >= 0 && reds > 0; y--){
            for (int x = world.length - 1; x >= 0 && reds > 0; x--){
                world[y][x] = Actor.RED;
                reds--;
            }
        }


        Actor[] actors = fromMatrix(world);
        for (int i = 0; i < actors.length; i++){
            if (actors[i] == null){
                actors[i] = Actor.NONE;
            }
        }
        shuffle(actors);
        world = toMatrix(actors);
    }
    int nActors(double distribution){
        return (int)(world.length*world.length*distribution);
    }

    void moveUnsatisfied(int[] arr){
        Integer[] shuffledArr = toInteger(arr);
        shuffle(shuffledArr);

        Actor[] actors = fromMatrix(world);
        Actor temp;
        for(int i=0; i<arr.length; i++){
            temp = actors[arr[i]];
            actors[arr[i]]=actors[shuffledArr[i]];
            actors[shuffledArr[i]]=temp;
        }

        world = toMatrix(actors);


    }
    Integer[] toInteger(int[] arr){
        Integer[] intarr = new Integer[arr.length];
        for(int k=0; k<arr.length; k++){
            intarr[k]=arr[k];
        }
        return intarr;
    }
    int[] addArrays(int[] arr1, int[] arr2){
        int[] returnArr = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++){
            returnArr[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++){
            returnArr[i + arr1.length] = arr2[i];
        }
        return returnArr;
    }
    int[] get(State inState){
        int[] returnArray;
        State[] states = fromMatrix(state);
        if (inState != State.NA){
            int length = 0;
            for (int i = 0; i < states.length; i++){
                if (states[i].equals(inState)){
                    length++;
                }
            }
            returnArray = new int[length];
        }
        else{
            int length = world.length*world.length - (int)nActors(distribution[0]) - (int)nActors(distribution[1]);
            returnArray = new int[length];
        }

        int pointer = 0;
        for (int i = 0; i < states.length; i++){
            if (states[i].equals(inState)){
                returnArray[pointer] = i;
                pointer++;
            }
        }

        return returnArray;
    }



    // --------- NOTHING to do below this --------------------------
    // --- Utility methods ----------------------------
    Actor[][] toMatrix(Actor[] arr) {
        int size = (int) round(sqrt(arr.length));
        Actor[][] matrix = new Actor[size][size];
        for (int i = 0; i < arr.length; i++) {
            matrix[i / size][i % size] = arr[i];
        }
        return matrix;
    }


    // Random shuffling of any reference type array
    <T> void shuffle(T[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i);
            T k = arr[i];
            arr[i] = arr[j];
            arr[j] = k;
        }
    }

    // ------ For Testing -----------------
    <T> void plot(T[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            out.println(Arrays.toString(matrix[row]));
        }
    }

    // ------- Graphics and Events -------------

    final int width = 400;
    final int height = 400;
    final int delay = 200;

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        int size = world.length;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int x = 10 * col + 50;
                int y = 10 * row + 50;

                if (world[row][col] == Actor.RED) {
                    g2.setColor(Color.RED);
                } else if (world[row][col] == Actor.BLUE) {
                    g2.setColor(Color.BLUE);
                } else {
                    g2.setColor(Color.WHITE);
                }
                g2.fillOval(x, y, 10, 10);
                /* If not satisfied put a mark on
                if (...) {
                    g2.setColor(Color.WHITE);
                    g2.fillOval(x, y, 4, 4);
                }*/
            }
        }
        Toolkit.getDefaultToolkit().sync();
    }

    void initGraphics() {
        setPreferredSize(new Dimension(width, height));
        JFrame window = new JFrame();
        window.setTitle("Simulation");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.add(this);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    void initEvents() {
        Timer timer = new Timer(delay, e -> {
            updateWorld();
            repaint();
        });
        timer.start();
    }
}