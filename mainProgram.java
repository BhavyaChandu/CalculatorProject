package myCalculatorfile;

import javax.swing.SwingUtilities;

public class mainProgram {

	public static void main(String[] args) {


		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new calculatorClass();
            }
        });

	}

}
