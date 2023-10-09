import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIFrame extends Prisoner implements ActionListener {

  public static JFrame frame;

  public static JButton button1;
  public static JButton button2;
  
  public static int total_button_presses = 0;
  public static int gamemode; 

  public static boolean first_panel = true;
  
  public GUIFrame(int xsize, int ysize, JButton buttonone, JButton buttontwo) {

    button1 = buttonone;
    button2 = buttontwo;
    frame = new JFrame();
    frame.setSize(xsize, ysize);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(button1);
    button1.addActionListener(this);
    frame.add(button2);
    button2.addActionListener(this);

    JPanel panel = new JPanel();
    panel.setBounds(100, 0, 300, 150);
    panel.setLayout(null);
    
    JLabel label = new JLabel();
    label.setLayout(null);
    label.setBounds(50, 0, 290, 140);
    label.setVisible(true);
    panel.add(label);

    if (first_panel) {
      label.setText("Choose your gamemode");
      first_panel = false;
    }
    else if (total_button_presses == 0 && !first_panel)
      label.setText("Prisoner One: Choose your fate");
    else if (total_button_presses == 1 && gamemode == 2)
      label.setText("Prisoner Two: Choose your fate");

    frame.add(panel);
  }

  public static JButton Button(String text, int xpos, int ypos, int width, int height) {
    JButton button = new JButton();
    button.setBounds(xpos, ypos, width, height);
    button.setText(text);
    button.setBackground(Color.darkGray);
    button.setForeground(Color.white);
    button.setFocusable(false);
    return button;
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button1) {
      
      if (total_button_presses == 0) {
        playGame();
        gamemode = 1;
      }
      else if (total_button_presses == 1) {
        Prisoner.inputone = false;
        playGame();
      }
      else if (total_button_presses == 2) {
        Prisoner.inputtwo = false;
      }

      total_button_presses++;
    }
      
    if (e.getSource() == button2) {
      if (total_button_presses == 0) {
        playGame();
        gamemode = 2;
      }
      else if (total_button_presses == 1) {
        Prisoner.inputone = true;
        playGame();
      }
      else if (total_button_presses == 2) {
        Prisoner.inputtwo = true;
      }
      
      total_button_presses++;  
    }

    if (total_button_presses == 2 && gamemode == 1)
      Prisoner.runDilemma(Prisoner.inputone, Prisoner.getComputerInput());

    else if (total_button_presses == 3)
      Prisoner.runDilemma(Prisoner.inputone, Prisoner.inputtwo);
  }
  
}