import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Assign3SetB1 extends JFrame {
    private JTextField displayField;
    private StringBuilder currentInput;
    private double result;
    private String operator;

    public Assign3SetB1() {
        // Initialize variables
        currentInput = new StringBuilder();
        result = 0;
        operator = "";

        // Set up the frame
        setTitle("Assign3SetB1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 500);

        // Create and configure components
        createView();
    }

    private void createView() {
        JPanel panel = new JPanel(new BorderLayout());
        getContentPane().add(panel);

        displayField = new JTextField();
        displayField.setEditable(false);
        displayField.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        panel.add(buttonPanel, BorderLayout.CENTER);

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "Exit"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(createButtonClickListener());
            buttonPanel.add(button);
        }
    }

    private ActionListener createButtonClickListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();

                switch (command) {
                    case "C": // Clear the display
                        currentInput.setLength(0);
                        displayField.setText("");
                        result = 0;
                        operator = "";
                        break;

                    case "Exit": // Exit the application
                        System.exit(0);
                        break;

                    case "=":
                        try {
                            result = calculate(result, Double.parseDouble(currentInput.toString()), operator);
                            displayField.setText(String.valueOf(result));
                            currentInput.setLength(0);
                            operator = "";
                        } catch (NumberFormatException ex) {
                            displayError("Invalid input.");
                        }
                        break;

                    case ".":
                        if (!currentInput.toString().contains(".")) {
                            currentInput.append(command);
                            displayField.setText(currentInput.toString());
                        }
                        break;

                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        try {
                            result = calculate(result, Double.parseDouble(currentInput.toString()), operator);
                            displayField.setText(String.valueOf(result));
                            currentInput.setLength(0);
                            operator = command;
                        } catch (NumberFormatException ex) {
                            displayError("Invalid input.");
                        }
                        break;

                    default: // Handle number buttons
                        if ("0123456789".contains(command)) {
                            if (command.equals("0")) {
                                if (currentInput.length() == 0 || currentInput.toString().endsWith("0")) {
                                    return; // Ignore additional leading zeros
                                }
                            }
                            currentInput.append(command);
                            displayField.setText(currentInput.toString());
                        }
                        break;
                }
            }
        };
    }

    private double calculate(double num1, double num2, String op) {
        switch (op) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/":
                if (num2 == 0) {
                    displayError("Cannot divide by zero.");
                    return num1;
                }
                return num1 / num2;
            default: return num2;
        }
    }

    private void displayError(String message) {
        JOptionPane.showMessageDialog(Assign3SetB1.this, message, "Error", JOptionPane.ERROR_MESSAGE);
        currentInput.setLength(0);
        displayField.setText("");
        result = 0;
        operator = "";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Assign3SetB1().setVisible(true);
        });
    }
}
