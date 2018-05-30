package Tutorials;

/**
 * Created by kenny on 2017-04-10.
 */
public class Part7 {

    int tWater = 0;

    public Part7(){
        //Default constructor
    }

    public Part7(int waterAmount){
        tWater = waterAmount;
    }

    public void addWater(int amount){
        tWater += amount;
    }
    public void drinkWater(int amount){
        tWater -= amount;
    }
    public int getWater(){
        return tWater;
    }
}
