import javax.swing.*;
import java.awt.*;

public class Main {
  public static void main(String[] args) {

    JButton button1 = GUIFrame.Button("One Player", 175, 97, 150, 30);
    JButton button2 = GUIFrame.Button("Two Player", 175, 175, 150, 30);
    
    new GUIFrame(500, 300, button1, button2);
    
  }
}