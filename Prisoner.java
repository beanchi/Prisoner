import javax.swing.*;
import java.awt.*;
import java.util.*;
//hi peter
//hi owen
public class Prisoner {
  
  static boolean inputone;
  static boolean inputtwo;
  static boolean twoplayer;
  static int result;
   
  public static void playGame() {
    JButton button1 = GUIFrame.Button("Conform", 175, 97, 150, 30);
    JButton button2 = GUIFrame.Button("Snitch", 175, 175, 150, 30);

    GUIFrame.frame.dispose();
    new GUIFrame(500, 300, button1, button2);
     
   }
   
   public static boolean getComputerInput() {
      Random rand = new Random();
      int temp = rand.nextInt(1000) % 2;
      if (temp == 0) {
            inputtwo = true;
            return inputtwo;
         } else {
            inputtwo = false;
            return inputtwo;
         }
   }
   
   public static void runDilemma(boolean inputone, boolean inputtwo) {
      if (inputone == inputtwo && inputone == true) {
        result = 0;
      }
      if (inputone == inputtwo && inputone == false) {
        result = 1;
      }
      if (inputone != inputtwo && inputone == true) {
        result = 2;
      }
      if (inputone != inputtwo && inputone == false) {
        result = 3;
      }

     showResult();
   }

  public static void showResult() {

    GUIFrame.frame.dispose();
    JFrame frame = new JFrame();
    frame.setSize(500, 300);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setBounds(125, 0, 500, 250);
    panel.setLayout(null);

    JLabel label = new JLabel();
    label.setLayout(null);
    label.setBounds(0, 0, 500, 300);
    label.setVisible(true);
    panel.add(label);
    
    if (result == 0)
      label.setText("<html>Damn. Y'all are traitors. <br>Both of you get three years in prison.<html>");
    if (result == 1)
      label.setText("<html>Wooo! You both took the best option for the <br>both of you. One year each<html>");
    if (result == 2)
      label.setText("<html>Prisoner Two gets five years and <br>Prisoner One gets no years.<html>");
    if (result == 3)
      label.setText("<html>Prisoner One gets five years and <br>Prisoner Two gets no years.<html>");

    frame.add(panel);
  }
}