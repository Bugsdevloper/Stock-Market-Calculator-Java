import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class margincalculator extends JFrame implements ActionListener {

    private JLabel lblStockPrice, lblQuantity, lblMarginRate, lblMarginAmount, lblTotalValue;
    private JTextField txtStockPrice, txtQuantity, txtMarginRate, txtMarginAmount, txtTotalValue;
    private JButton btnCalculate;

    public margincalculator() {
    	 ImageIcon icon = new ImageIcon(getClass().getResource("j2.jpg"));
         setIconImage(icon.getImage());
        setTitle("Margin Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 250);
        setResizable(false);
        setLocationRelativeTo(null);
        // Create the main panel and add components
        JPanel mainPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        lblStockPrice = new JLabel("Stock Price:");
        txtStockPrice = new JTextField(10);
        lblQuantity = new JLabel("Quantity:");
        txtQuantity = new JTextField(10);
        lblMarginRate = new JLabel("Margin Rate (%):");
        txtMarginRate = new JTextField(10);
        lblMarginAmount = new JLabel("Margin Amount:");
        txtMarginAmount = new JTextField(10);
        lblTotalValue = new JLabel("Total Value:");
        txtTotalValue = new JTextField(10);
        txtMarginAmount.setEditable(false);
        txtTotalValue.setEditable(false);

        btnCalculate = new JButton("Calculate");
        btnCalculate.addActionListener(this);

        mainPanel.add(lblStockPrice);
        mainPanel.add(txtStockPrice);
        mainPanel.add(lblQuantity);
        mainPanel.add(txtQuantity);
        mainPanel.add(lblMarginRate);
        mainPanel.add(txtMarginRate);
        mainPanel.add(lblMarginAmount);
        mainPanel.add(txtMarginAmount);
        mainPanel.add(lblTotalValue);
        mainPanel.add(txtTotalValue);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnCalculate);

        // Add the main panel and button panel to the frame
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(mainPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalculate) {
            double stockPrice = Double.parseDouble(txtStockPrice.getText());
            int quantity = Integer.parseInt(txtQuantity.getText());
            double marginRate = Double.parseDouble(txtMarginRate.getText());

            double marginAmount = stockPrice * quantity * marginRate / 100;
            double totalValue = stockPrice * quantity + marginAmount;

            txtMarginAmount.setText(String.format("%.2f", marginAmount));
            txtTotalValue.setText(String.format("%.2f", totalValue));
        }
    }

    public static void main(String[] args) {
        
    }
}