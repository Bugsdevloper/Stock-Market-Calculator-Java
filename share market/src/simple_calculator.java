import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class simple_calculator extends JFrame implements ActionListener {

   private JTextField displayField;
   private JPanel buttonPanel;
   private JButton[] buttons;
   private String[] buttonLabels = {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "0", ".", "C", "/", "="};

   private double num1 = 0, num2 = 0;
   private String operator = "";

   public simple_calculator() {
	  
      // Set up the JFrame properties
      setTitle("Calculator");
      setSize(300, 400);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      ImageIcon icon = new ImageIcon(getClass().getResource("icon1.jpg"));
      setIconImage(icon.getImage());
    
      // Create the display field
      displayField = new JTextField();
      displayField.setColumns(20);
      displayField.setEditable(false);
      displayField.setBackground(Color.WHITE);
      displayField.setPreferredSize(new Dimension(displayField.getPreferredSize().width, 50));
      displayField.setFont(new Font("Arial", Font.BOLD, 20));

      // Create the button panel
      buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));

      // Create the buttons
      buttons = new JButton[buttonLabels.length];

      for (int i = 0; i < buttonLabels.length; i++) {
         buttons[i] = new JButton(buttonLabels[i]);
         buttons[i].addActionListener(this);
         if (i == 3 || i == 7 || i == 11 || i == 15 || i == 16 || i == 19) {
            buttons[i].setBackground(Color.ORANGE);

         }

         else if(i == 14 ) {
             buttons[i].setBackground(Color.RED);

         }

         else {
            buttons[i].setBackground(Color.WHITE);
         }
         buttons[i].setFocusable(false);
         buttonPanel.add(buttons[i]);
      }

      // Add components to the JFrame
      add(displayField, BorderLayout.NORTH);
      add(buttonPanel, BorderLayout.CENTER);

   }

   @Override
   public void actionPerformed(ActionEvent e) {
       SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               String buttonText = ((JButton)e.getSource()).getText();
               if (buttonText.equals("C")) {
                   displayField.setText("");
                   num1 = 0;
                   num2 = 0;
                   operator = "";
               } else if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/")) {
                   operator = buttonText;
                   num1 = Double.parseDouble(displayField.getText());
                   displayField.setText("");
               } else if (buttonText.equals("=")) {
                   num2 = Double.parseDouble(displayField.getText());
                   double result = 0;
                   if (operator.equals("+")) {
                       result = num1 + num2;
                   } else if (operator.equals("-")) {
                       result = num1 - num2;
                   } else if (operator.equals("*")) {
                       result = num1 * num2;
                   } else if (operator.equals("/")) {
                       result = num1 / num2;
                   }
                   displayField.setText(Double.toString(result));
               } else {
                   displayField.setText(displayField.getText() + buttonText);
               }
           }
       });
   }


     public static void main(String[] args) {
    	 
        }
    }
