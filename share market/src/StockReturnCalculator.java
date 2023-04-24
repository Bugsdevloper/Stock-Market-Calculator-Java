import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockReturnCalculator extends JFrame {
    private JLabel initialPriceLabel, currentPriceLabel, numberOfSharesLabel, resultLabel;
    private JTextField initialPriceField, currentPriceField, numberOfSharesField, resultField;
    private JButton calculateButton;
  

    public StockReturnCalculator() {
        setTitle("Stock Return Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon icon = new ImageIcon(getClass().getResource("r2.jpg"));
        setIconImage(icon.getImage());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        initialPriceLabel = new JLabel("Initial Stock Price:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(initialPriceLabel, constraints);

        initialPriceField = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(initialPriceField, constraints);

        currentPriceLabel = new JLabel("Current Stock Price:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(currentPriceLabel, constraints);

        currentPriceField = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(currentPriceField, constraints);

        numberOfSharesLabel = new JLabel("Number of Shares:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(numberOfSharesLabel, constraints);

        numberOfSharesField = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(numberOfSharesField, constraints);

        calculateButton = new JButton("Calculate");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(calculateButton, constraints);

        resultLabel = new JLabel("Total Return:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(resultLabel, constraints);

        resultField = new JTextField(10);
        resultField.setEditable(false);
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(resultField, constraints);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottomPanel.add(panel);
        add(bottomPanel, BorderLayout.CENTER);

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel titleLabel = new JLabel("Stock Return Calculator", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        JButton closeButton = new JButton("Close");
        buttonPanel.add(closeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double initialPrice = Double.parseDouble(initialPriceField.getText());
                    double currentPrice = Double.parseDouble(currentPriceField.getText());
                    double numberOfShares = Double.parseDouble(numberOfSharesField.getText());
                    // Calculate total return
                    double totalReturn = (currentPrice - initialPrice) * numberOfShares;

                    // Set result field with total return formatted as currency
                    resultField.setText(String.format("%.2f", totalReturn));


                } catch (NumberFormatException ex) {
                    // Display error message if any of the input fields are not valid numbers
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers for all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
       
    }

}