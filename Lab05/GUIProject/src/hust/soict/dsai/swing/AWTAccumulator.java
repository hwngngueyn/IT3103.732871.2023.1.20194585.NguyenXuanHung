package hust.soict.dsai.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//accumulator using AWT
public class AWTAccumulator extends Frame {
	// 2 text Flied cho việc nhập và xuất dữ liệu
	private TextField tfInput;
	private TextField tfOutput;
	private int sum = 0; 	// Accumulated sum, init = 0

	// constructor to set up the GUI components and event handlers
	public AWTAccumulator() {
		setLayout(new GridLayout(2, 2));	// set layout to GridLayout

		// Thành phần input
		add(new JLabel("Enter an integer: ")); // add an anonymous JLabel with text
		tfInput = new TextField(10); // create a JTextField component
		add(tfInput); // add it to the content-pane
		tfInput.addActionListener(new TFInputListener()); // add a listener

		add(new JLabel("The accumulated sum is: ")); // add an anonymous JLabel with text

		// Thành phần output
		tfOutput = new TextField(10); // create a JTextField component
		tfOutput.setEditable(false); // cause this is output, set it unable to edit
		add(tfOutput); // add it to the content-pane

		setTitle("Nguyen Xuan Hung's AWT Accumulator"); // set title of the stage
		setSize(400, 150); // set size of the stage
		setVisible(true); // set it visible = true
	}
	// main method to invoke the AWTAccumulator constructor to set up the GUI
	public static void main(String[] args) {
		new AWTAccumulator();
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
