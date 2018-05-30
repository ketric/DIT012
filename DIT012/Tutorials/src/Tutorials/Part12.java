package Tutorials;
import javax.swing.JOptionPane;
public class Part12 {

/*    public static void main(String[] args){

        String fingers = JOptionPane.showInputDialog("How many fingers do you have?");
        JOptionPane.showMessageDialog(null,"you have " + fingers + " fingers!");
    }
    */
      public static void main(String[] args){

          Double number = Double.parseDouble(JOptionPane.showInputDialog("what is 3/2?"));

          if ((number - 1.5) < .00001){

              JOptionPane.showMessageDialog(null, "you are correct!");
          }
          else{
              JOptionPane.showMessageDialog(null, "You are wrong!");
          }
      }
}
