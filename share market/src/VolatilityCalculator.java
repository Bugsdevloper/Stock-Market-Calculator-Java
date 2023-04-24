import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VolatilityCalculator extends JFrame {
    // Define GUI components
    private JTextField stockPriceTextField;
    private JTextField returnsTextField;
    private JTextField standardDeviationTextField;
    private JButton calculateButton;
    private JLabel volatilityLabel;

    public VolatilityCalculator() {
        // Set up the JFrame properties
    	ImageIcon icon = new ImageIcon(getClass().getResource("j1.jpeg"));
        setIconImage(icon.getImage());
        setTitle("Volatility Calculator");
        setSize(400, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create the main JPanel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);

        // Create the input fields
        JLabel stockPriceLabel = new JLabel("Stock Price:");
        stockPriceTextField = new JTextField(10);
        JLabel returnsLabel = new JLabel("Returns (%):");
        returnsTextField = new JTextField(10);
        JLabel standardDeviationLabel = new JLabel("Standard Deviation (%):");
        standardDeviationTextField = new JTextField(10);

        // Add the input fields to the main panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(stockPriceLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(stockPriceTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(returnsLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(returnsTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(standardDeviationLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(standardDeviationTextField, gbc);

        // Create the calculate button and add an action listener
        calculateButton = new JButton("Calculate Volatility");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateVolatility();
            }
        });

        // Add the calculate button to the main panel
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(calculateButton, gbc);

        // Create the volatility label
        volatilityLabel = new JLabel("", SwingConstants.CENTER);

        // Add the volatility label to the main panel
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(volatilityLabel, gbc);

        // Add the main panel to the JFrame
        getContentPane().add(mainPanel, BorderLayout.CENTER);
    }

    private void calculateVolatility() {
        // Get the input values
        double stockPrice = Double.parseDouble(stockPriceTextField.getText());
        double returns = Double.parseDouble(returnsTextField.getText()) / 100;
        double standardDeviation = Double.parseDouble(standardDeviationTextField.getText()) / 100;

        // Calculate the volatility
        double volatility = Math.sqrt(Math.log(1 + Math.pow(returns, 2)) + Math.pow(standardDeviation, 2));

        // Set the volatility label
        volatilityLabel.setText("Volatility: " + String.format("%.2f%%", volatility * 100));
    }

    public static void main(String[] args) {
        
    }
}
