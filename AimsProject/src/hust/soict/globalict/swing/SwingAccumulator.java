package AimsProject.src.hust.soict.globalict.swing;

import java.awt.*; // Using AWT's layouts
import java.awt.event.*; // Using AWT's event classes and listener interfaces
import javax.swing.*; // Using Swing components and containers

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));

        cp.add(new JLabel("Enter an integer: "));

        tfInput = new JTextField(10);   
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        cp.add(new JLabel("The accumulated Sum is:"));

        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        setTitle("Swing Accumulator");
        setSize(350, 120);
        setVisible(true);

    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }

    // Define an inner class to handle the input TextField.
    // An ActionEvent listener must implement ActionListener interface.
    private class TFInputListener implements ActionListener {
        // ActionEvent handler - Called back upon hitting "enter" key on TextField
        @Override
        public void actionPerformed(ActionEvent evt) {
            // Get the String entered into the TextField tfInput, convert to int
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn; // Accumulate numbers entered into sum
            tfInput.setText(""); // Clear input TextField
            tfOutput.setText(sum + ""); // Display sum on the output TextField
                                        // convert int to String
        }
    }

}
