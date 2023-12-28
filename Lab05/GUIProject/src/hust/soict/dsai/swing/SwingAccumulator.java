package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//accumulator using Swing
public class SwingAccumulator extends JFrame {
	// 2 trường nhập input và output
	private JTextField tfInput;
	private JTextField tfOutput;
	private int sum = 0; // Accumulated sum, init = 0
	// constructor to set up the GUI components and event handlers
	public SwingAccumulator() {
		Container cp = getContentPane();	// get the content-pane of the top-level container
		cp.setLayout(new GridLayout(2, 2));	// set layout to GridLayout

		// phần input
		cp.add(new JLabel("Enter an integer: ")); // add an anonymous JLabel with text
		tfInput = new JTextField(10); // create a JTextField component
		cp.add(tfInput); // add it to the content-pane
		tfInput.addActionListener(new TFInputListener()); // add a listener which takes this JTextField component as the source.
		// phần output
		cp.add(new JLabel("The accumulated sum is: ")); // add an anonymous JLabel with text
		tfOutput = new JTextField(10); // create a JTextField component
		tfOutput.setEditable(false); // cause this is output, set it unable to edit
		cp.add(tfOutput); // add it to the content-pane

		setTitle("Nguyen Xuan Hung's Swing Accumulator"); // set title of the stage
		setSize(350, 120); // set size of the stage
		setVisible(true); // set it visible
	}
	// main method to invoke the SwingAccumulator constructor to set up the GUI
	public static void main(String[] args) {
		new SwingAccumulator();
	}
	// event handler, implements ActionListener
	private class TFInputListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int numberIn = Integer.parseInt(tfInput.getText()); // parse the enter number
			sum += numberIn; // add to sum
			tfInput.setText(""); // erase the old input
			tfOutput.setText(sum + ""); // print the new output
		}
	}
}
