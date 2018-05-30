package Tutorials;

public class usePart7 {

    public static void main(String[] args){

        Part7 waterBottle = new Part7(0);

        waterBottle.addWater(100); //Add 100 liters of water
        waterBottle.drinkWater(20); //Drink 20 liters of water

        System.out.println("Remaining water level is: "+waterBottle.getWater());
        //Checks amount of water left.
    }
}
