import javax.swing.*;
import java.awt.*;

public class BMICalculatorFullScreen {
    private JFrame frame;
    private JPanel panel;
    private JLabel weightLabel;
    private JTextField weightField;
    private JLabel heightLabel;
    private JTextField heightField;
    private JButton calculateButton;
    private JLabel bmiLabel;
    private JTextField bmiField;

    public BMICalculatorFullScreen() {
        frame = new JFrame("BMI Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);

        // Create the starting screen panel
        JPanel startPanel = new JPanel(new GridBagLayout());
        startPanel.setBackground(Color.WHITE);
        JLabel startLabel = new JLabel("Welcome to the BMI Calculator. Do you want to continue?");
        JButton yesButton = new JButton("Yes");
        startPanel.add(startLabel);
        startPanel.add(yesButton);
        frame.getContentPane().add(startPanel);

        // When the yes button is clicked, remove the start panel and show the calculator panel
        yesButton.addActionListener(e -> {
            frame.getContentPane().remove(startPanel);

            panel = new JPanel(new GridBagLayout());
            panel.setBackground(Color.WHITE);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);

            weightLabel = new JLabel("Weight (kg):");
            gbc.gridx = 0;
            gbc.gridy = 0;
            panel.add(weightLabel, gbc);

            weightField = new JTextField(10);
            gbc.gridx = 1;
            gbc.gridy = 0;
            panel.add(weightField, gbc);

            heightLabel = new JLabel("Height (m):");
            gbc.gridx = 0;
            gbc.gridy = 1;
            panel.add(heightLabel, gbc);

            heightField = new JTextField(10);
            gbc.gridx = 1;
            gbc.gridy = 1;
            panel.add(heightField, gbc);

            calculateButton = new JButton("Calculate");
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            panel.add(calculateButton, gbc);

            bmiLabel = new JLabel("BMI:");
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            panel.add(bmiLabel, gbc);

            bmiField = new JTextField(10);
            bmiField.setEditable(false);
            gbc.gridx = 1;
            gbc.gridy = 3;
            panel.add(bmiField, gbc);

            calculateButton.addActionListener(evt -> {
                double weight, height, bmi;

                try {
                    weight = Double.parseDouble(weightField.getText());
                    height = Double.parseDouble(heightField.getText());

                    if (weight <= 0 || height <= 0) {
                        JOptionPane.showMessageDialog(frame, "Weight and height must be positive numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    bmi = weight / (height * height);

                    bmiField.setText(String.format("%.1f", bmi));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers for weight and height.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            frame.getContentPane().add(panel);
            frame.setVisible(true);
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BMICalculatorFullScreen();
    }
}
