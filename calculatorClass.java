package myCalculatorfile;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculatorClass {


    private JFrame frame;
    private JPanel panel;
    private JTextField display;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton equalsButton;
    private JButton clearButton;

    private double num1;
    private String operator = ""; // Initialize operator to an empty string
    private boolean start;

    public calculatorClass() {
        frame = new JFrame("calculatorClass");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));

        display = new JTextField();
        display.setEditable(false);
        panel.add(display);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (start) {
                        display.setText("");
                        start = false;
                    }
                    display.setText(display.getText() + ((JButton) e.getSource()).getText());
                }
            });
            panel.add(numberButtons[i]);
        }

        operatorButtons = new JButton[4];
        String[] operators = {"+", "-", "*", "/"};
        for (int i = 0; i < 4; i++) {
            operatorButtons[i] = new JButton(operators[i]);
            operatorButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String op = ((JButton) e.getSource()).getText();
                    if (!start) {
                        calculate();
                    }
                    start = true;
                    operator = op;
                    num1 = Double.parseDouble(display.getText());
                }
            });
            panel.add(operatorButtons[i]);
        }

        equalsButton = new JButton("=");
        equalsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate();
                display.setText(String.valueOf(num1));
                start = true;
            }
        });
        panel.add(equalsButton);

        clearButton = new JButton("C");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1 = 0;
                operator = ""; // Reset operator to empty string
                start = true;
                display.setText("");
            }
        });
        panel.add(clearButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void calculate() {
        double num2 = Double.parseDouble(display.getText());
        switch (operator) {
            case "+":
                num1 += num2;
                break;
            case "-":
                num1 -= num2;
                break;
            case "*":
                num1 *= num2;
                break;
            case "/":
                if (num2 != 0) {
                    num1 /= num2;
                } else {
                    display.setText("Error");
                }
                break;
        }
    }


}
