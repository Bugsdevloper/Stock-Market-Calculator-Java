import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class optioncalculator extends JFrame implements ActionListener {

    private JTextField stockPriceField, strikePriceField, riskFreeRateField, volatilityField, timeToMaturityField;
    private JLabel callPriceLabel, putPriceLabel;
    private JButton calculateButton;

    public optioncalculator() {
    	ImageIcon icon = new ImageIcon(getClass().getResource("j1.jpeg"));
        setIconImage(icon.getImage());
        setTitle("Option Calculator");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        JLabel stockPriceLabel = new JLabel("Stock Price:");
        stockPriceField = new JTextField(10);
        panel.add(stockPriceLabel);
        panel.add(stockPriceField);

        JLabel strikePriceLabel = new JLabel("Strike Price:");
        strikePriceField = new JTextField(10);
        panel.add(strikePriceLabel);
        panel.add(strikePriceField);

        JLabel riskFreeRateLabel = new JLabel("Risk Free Rate:");
        riskFreeRateField = new JTextField(10);
        panel.add(riskFreeRateLabel);
        panel.add(riskFreeRateField);

        JLabel volatilityLabel = new JLabel("Volatility:");
        volatilityField = new JTextField(10);
        panel.add(volatilityLabel);
        panel.add(volatilityField);

        JLabel timeToMaturityLabel = new JLabel("Time to Maturity:");
        timeToMaturityField = new JTextField(10);
        panel.add(timeToMaturityLabel);
        panel.add(timeToMaturityField);

        callPriceLabel = new JLabel("Call Price:");
        panel.add(callPriceLabel);

        putPriceLabel = new JLabel("Put Price:");
        panel.add(putPriceLabel);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        panel.add(calculateButton);

        getContentPane().add(panel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            double stockPrice = Double.parseDouble(stockPriceField.getText());
            double strikePrice = Double.parseDouble(strikePriceField.getText());
            double riskFreeRate = Double.parseDouble(riskFreeRateField.getText());
            double volatility = Double.parseDouble(volatilityField.getText());
            double timeToMaturity = Double.parseDouble(timeToMaturityField.getText());

            double callPrice = calculateCallPrice(stockPrice, strikePrice, riskFreeRate, volatility, timeToMaturity);
            double putPrice = calculatePutPrice(stockPrice, strikePrice, riskFreeRate, volatility, timeToMaturity);

            callPriceLabel.setText("Call Price: " + String.format("%.2f", callPrice));
            putPriceLabel.setText("Put Price: " + String.format("%.2f", putPrice));
        }
    }

    private double calculateCallPrice(double stockPrice, double strikePrice, double riskFreeRate, double volatility, double timeToMaturity) {
        double d1 = (Math.log(stockPrice / strikePrice) + (riskFreeRate + Math.pow(volatility, 2) / 2) * timeToMaturity) / (volatility * Math.sqrt(timeToMaturity));
        double d2 = d1 - volatility * Math.sqrt(timeToMaturity);
        return stockPrice * calculateN(d1) - strikePrice * Math.exp(-riskFreeRate * timeToMaturity) * calculateN(d2);
    }

    private double calculatePutPrice(double stockPrice, double strikePrice, double riskFreeRate, double volatility, double timeToMaturity) {
    	double d1 = (Math.log(stockPrice / strikePrice) + (riskFreeRate + Math.pow(volatility, 2) / 2) * timeToMaturity) / (volatility * Math.sqrt(timeToMaturity));
        double d2 = d1 - volatility * Math.sqrt(timeToMaturity);
        return strikePrice * Math.exp(-riskFreeRate * timeToMaturity) * calculateN(-d2) - stockPrice * calculateN(-d1);
        }

        private double calculateN(double x) {
        double L, K, w ;
        double a1 = 0.31938153;
        double a2 = -0.356563782;
        double a3 = 1.781477937;
        double a4 = -1.821255978;
        double a5 = 1.330274429;
        K = 1.0 / (1.0 + 0.2316419 * Math.abs(x));
        L = 1.0 / Math.sqrt(2 * Math.PI) * Math.exp(-1 * Math.pow(x, 2) / 2.0);
        w = 1.0 - 1.0 / Math.pow(1.0 + 0.2316419 * Math.abs(x), 1.0 * a1)
        * Math.exp(-1 * Math.pow(x, 2) / 2 * (1 + a2 * K + a3 * Math.pow(K, 2) + a4 * Math.pow(K, 3) + a5 * Math.pow(K, 4)));
        if (x < 0) {

        	w = 1.0 - w;
   }
        return w;
  }

 public static void main(String[] args) {
 	} 
 }