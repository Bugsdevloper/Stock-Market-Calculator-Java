import javax.swing.*;
import javax.swing.UIManager.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StockMarketGUI extends JFrame {
    public StockMarketGUI() {
        // Set up the JFrame properties
        setTitle("Stock Market");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon(getClass().getResource("r1.jpg"));
        setIconImage(icon.getImage());

        // Set a custom background color
        getContentPane().setBackground(new Color(23, 45, 67));

        // Set the look and feel to Nimbus
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, fall back to the default look and feel
            System.out.println("Nimbus look and feel not found");
        }

        // Create the menu bar and menus
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Calculators");
        JMenu helpMenu = new JMenu("Help");

     // Create a label and set its properties
        JLabel titleLabel = new JLabel("Click the Calculator tab at the top to access calculators. Click Help to get in touch with me or report bugs.");
        titleLabel.setFont(new Font("Bodoni MT Black", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add the label to the JFrame
        add(titleLabel, BorderLayout.NORTH);

        // Create menu items for the calculators menu
        JMenuItem simpleCalcItem = new JMenuItem("Simple Calculator");
        JMenuItem joe = new JMenuItem("Return Calculator");
        JMenuItem joe1 = new JMenuItem("Margin Calculator");
        JMenuItem simpleCalcItem2 = new JMenuItem("volatility calculator");
        JMenuItem joe2 = new JMenuItem("Option Calculator");
        
        JMenuItem helpAndAboutItem = new JMenuItem("Contact, About, Bug Report");
        helpAndAboutItem.addActionListener(e -> {
            help_and_about help = new help_and_about();
            help.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    ((JFrame) e.getSource()).setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                }
            });
            help.setVisible(true);
        });

        simpleCalcItem.addActionListener(e -> {
            simple_calculator calc = new simple_calculator();
            calc.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    ((JFrame) e.getSource()).setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                }
            });
            calc.setVisible(true);
        });

        simpleCalcItem2.addActionListener(e -> {
           VolatilityCalculator roi = new VolatilityCalculator();
            roi.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    ((JFrame) e.getSource()).setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                }
            });
            roi.setVisible(true);
        });
        
        joe.addActionListener(e -> {
            StockReturnCalculator roi = new StockReturnCalculator();
             roi.addWindowListener(new WindowAdapter() {
                 @Override
                 public void windowClosing(WindowEvent e) {
                     ((JFrame) e.getSource()).setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                 }
             });
             roi.setVisible(true);
         });
        
        joe1.addActionListener(e -> {
            margincalculator rem = new margincalculator();
             rem.addWindowListener(new WindowAdapter() {
                 @Override
                 public void windowClosing(WindowEvent e) {
                     ((JFrame) e.getSource()).setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                 }
             });
             rem.setVisible(true);
         });
      
        joe2.addActionListener(e -> {
            optioncalculator rm = new optioncalculator();
             rm.addWindowListener(new WindowAdapter() {
                 @Override
                 public void windowClosing(WindowEvent e) {
                     ((JFrame) e.getSource()).setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                 }
             });
             rm.setVisible(true);
         });
        
        // Add menu items to the calculators menu
        fileMenu.add(simpleCalcItem);
        fileMenu.add(simpleCalcItem2);
        fileMenu.add(joe);
        fileMenu.add(joe1);
        fileMenu.add(joe2);
        helpMenu.add(helpAndAboutItem);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        // Set the menu bar for the JFrame
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        StockMarketGUI gui = new StockMarketGUI();
        gui.setVisible(true);
    }
}
